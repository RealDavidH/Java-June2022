# Login/Reg Template

```html
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ page isErrorPage="true"%>

<!-- for Form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>title goes here</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    </head>
    <body class="bg-dark text-light p-4">
        <div class="container-fluid">
            <h1 class="text-primary">Welcome</h1>
            <p>Join our growing community!</p>
        </div>
        <!-- !!! REGISTER FORM !!! -->
        <div class="container-fluid d-flex flex-row">
            <form:form
                action="/register"
                method="post"
                modelAttribute="newUser"
                class="col-6"
            >
                <p class="fs-2">Register</p>
                <p>
                    <form:label class="form-label" path="username"
                        >User name:</form:label
                    >
                    <form:errors path="username" />
                    <form:input class="form-control w-50" path="username" />
                </p>
                <p>
                    <form:label class="form-label" path="email"
                        >Email:</form:label
                    >
                    <form:errors path="email" />
                    <form:input class="form-control w-50" path="email" />
                </p>
                <p>
                    <form:label class="form-label" path="password"
                        >Password:</form:label
                    >
                    <form:errors path="password" />
                    <form:password class="form-control w-50" path="password" />
                </p>
                <p>
                    <form:label class="form-label" path="confirmPassword"
                        >Confirm Password:</form:label
                    >
                    <form:errors path="confirmPassword" />
                    <form:password
                        class="form-control w-50"
                        path="confirmPassword"
                    />
                </p>
                <input type="submit" value="Submit" class="btn btn-primary" />
            </form:form>

            <!-- !!! LOGIN FORM !!! -->
            <form:form
                action="/login"
                method="post"
                modelAttribute="loginUser"
                class="col-6"
            >
                <p class="fs-2">Login</p>
                <p>
                    <form:label class="form-label" path="email"
                        >Email:</form:label
                    >
                    <form:errors path="email" />
                    <form:input class="form-control w-50" path="email" />
                </p>
                <p>
                    <form:label class="form-label" path="password"
                        >Password:</form:label
                    >
                    <form:errors path="password" />
                    <form:password class="form-control w-50" path="password" />
                </p>
                <input type="submit" value="Submit" class="btn btn-primary" />
            </form:form>
        </div>
    </body>
</html>
```

# Login user template

```java
public class LoginUser {

	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;

	@NotEmpty(message="Password is Required!")
	@Size(min=8, max=128, message="Password must be at least 8 characters!")
	private String password;

	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
```

# Controller

```java
@Controller
public class LoginController {
	// private final UserServ serv;
	// public LoginController(UserServ serv) {
	// 	this.serv = serv;
	// }
@RequestMapping("/") //this could be different
	public String loadLoginReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "login.jsp";
	}
@RequestMapping("/register")
	public String checkReg(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = serv.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			!return!; // set a return redirect here
		} else {

			session.setAttribute("uuid", user.getId());
			System.out.println(user);
			 !return!; // set a return redirect here
		}
	}
	@RequestMapping("/login")
	public String checkLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User user = serv.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			!return!; // set a return redirect here
		}

		session.setAttribute("uuid", user.getId());
			!return!; // set a return redirect here
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		return "redirect:/";
	}
}
```

# Services

```java
public User register(User newUser, BindingResult result) {
		System.out.println(newUser.getConfirmPassword());
		System.out.println(newUser.getPassword());

		if(!newUser.getConfirmPassword().equals(newUser.getPassword())) {
			result.rejectValue("password", "matches", "Passwords must match!");
		}

		if(repo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "unquie", "Email already in use!");
		}
		if(result.hasErrors()) {
			return null;
		}

		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return repo.save(newUser);
	}
	public User login(LoginUser loginUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> opUser = repo.findByEmail(loginUser.getEmail());
		if(!opUser.isPresent()) {
			result.rejectValue("email", "unique", "Invalid Credentials");
			return null;
		}
		User user = opUser.get();
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Invalid Credentials");
			return null;
		}
		if(result.hasErrors()) {
			return null;
		}

		return user;
		}

```

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentsController {
    final StudentsRepository repository;
    private String message;

    public StudentsController(StudentsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String defPage(@RequestParam(value = "username", required = false, defaultValue = "defaultLogin") String username,
                          @RequestParam(value = "password", required = false, defaultValue = "defaultPassword") String password,
                          @RequestParam(value = "user_token", required = false, defaultValue = "defaultUserToken") String userToken,
                          Model model) {
        if (username.equals("defaultLogin") || password.equals("defaultPassword")
                || userToken.equals("defaultUserToken")) {
            return "home";
        }

        message = "lol";
//        model.addAttribute("message", username + "\n" + password + "\n" + userToken);
        model.addAttribute("message", repository.existsByUsernameAndAndPasswordAndUserToken(username, password, userToken));
        return "home";
    }
}

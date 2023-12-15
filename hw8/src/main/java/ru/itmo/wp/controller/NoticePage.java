package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.form.NoticeForm;
import ru.itmo.wp.form.validator.NoticeFormValidator;
import ru.itmo.wp.form.validator.UserCredentialsEnterValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class NoticePage extends Page {

    private final NoticeFormValidator noticeFormValidator;

    public NoticePage(NoticeFormValidator noticeFormValidator) {
        this.noticeFormValidator = noticeFormValidator;;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(noticeFormValidator);
    }



    @GetMapping("/notice")
    public String noticeGet(Model model) {
        System.out.println("noticeStart");
        model.addAttribute("noticeForm", new NoticeForm());
        System.out.println("noticeEnd");
        return "NoticePage";
    }

    @PostMapping("/notice")
    public String noticePost(@Valid @ModelAttribute("noticeForm") NoticeForm noticeForm,
                               BindingResult bindingResult,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "NoticePage";
        }

        noticeService.save(noticeForm);

        setMessage(httpSession, "Congrats, you have successfully added new notice");

        return "redirect:/";
    }
}

package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.form.NoticeForm;
import ru.itmo.wp.form.UserCredentials;


@Component
public class NoticeFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return NoticeForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            NoticeForm noticeForm = (NoticeForm) target;
            System.out.println("validation");
            System.out.println(((NoticeForm) target).getContent());
            if (noticeForm.getContent().trim().equals("") || noticeForm.getContent().trim().length() < 4) {
                System.out.println("not validated");
                errors.rejectValue(
                        "content", "content.wrong-notice-size", "Invalid content size");
            }
        }
    }
}

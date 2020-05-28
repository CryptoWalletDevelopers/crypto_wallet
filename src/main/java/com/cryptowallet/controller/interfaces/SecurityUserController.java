package com.cryptowallet.controller.interfaces;

import com.cryptowallet.entities.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public interface SecurityUserController {

    /**
     *  Передает пустой шаблон User на сайт, для дальнейшего заполнения и регистрации нового пользователя
     *
     * @param model набор данных передаваемых на фронт
     * @return страница регистрации
     */
    String signUp(Model model);

    /**
     *  Принимает заполненный шаблон пользователя (login, email, password),
     *  проверяет на корректность введенных данных и в случае успеха сохраняет в базе данных и производит автовход.
     *  В противном случае редиректит обратно
     *
     * @param user набор данных принимаемый от фронта, содержащий логин, пароль, email и др.
     *      @see User
     * @param model набор данных передаваемых на фронт
     * @param request в данном случае служит исключительно для автоматического входа в учетную запись
     *                после регистрауии пользователя
     * @return в случае успеха - возвращает на главную страницу,
     *      в случае неудачи - возвращает на страницу регистрации с указанием причины
     */
    String createUser(@ModelAttribute(name = "user") User user, Model model, HttpServletRequest request);

    /**
     *  Перенаправляет на страницу входа на сайт
     * @return Перенаправляет на страницу входа на сайт
     */
    String getLoginPage();

    /**
     *  Подтверждение почты пользователя по введенной ссылке.
     *
     * @param model набор данных передаваемых на фронт
     * @param code ранее сгенерированный нами токен, необходимый для подтверждения почты пользователя
     * @return возвращает на главную страницу сайта
     */
    String activateUser(Model model, String code);

    /**
     *  Перенаправляет на страницу восстановления пароля
     * @return Перенаправляет на страницу восстановления пароля
     */
    String getRestorePassword();

    /**
     *  Управление повторной отправки токена для подтверждения почты.
     *
     * @param model набор данных передаваемых на фронт
     * @param login логин пользователя инициирующего повторную отправку подтверждения почты.
     * @return В случае успеха перенаправляет на главную страницу. В противном случае оставляет тут же.
     */
    String sendMailRestorePassword(Model model, String login);

    /**
     *  Проверяет "свежесть" ссылки и в случае валидности передает управление сервису восстановления пароля,
     *  в противном случае генерирует и отправляет новую ссылку для восстановления пароля.
     *
     * @param model набор данных передаваемых на фронт
     * @param code token вписанный в ссылку. Проверяется с информацией из базы данных в поле token пользователя.
     * @return перенаправляет на страничку сохранения нового пароля.
     */
    String restoreUser(Model model, String code);

    /**
     *  Принимает форму содержащую пароль пользователя, проверяет валидность введенных данных.
     *  В случае корректности сохраняет новый пароль. В противном случае возвращает обратно.
     *  Так же производит подтверждение почтового ящика в случае успеха.
     *
     * @param model набор данных передаваемых на фронт
     * @param password новый пароль введенный пользователем
     * @param email почтовый ящик пользователя.
     * @return  В случае корректности сохраняет новый пароль. В противном случае возвращает обратно
     */
    String saveNewPassword(Model model,
                          @RequestParam(name = "password") String password,
                          @RequestParam(name = "email") String email);

    /**
     *  Если пользователь авторизован на сайте - перенаправляет на страничку профиля с лично информацией пользователя,
     *  в ином случае отправляет на страницу входа на сайт.
     * Доступ к страничке профиля ограничен на уровне config-файла.
     *
     * @see com.cryptowallet.configuration.SecurityConfig
     * @param model набор данных передаваемых на фронт
     * @param principal авторизванный пользователь
     * @return возвращает страничку профиля пользователя
     */
    String userProfile(Model model, Principal principal);

    /**
     * Метод повторной отправки токена вызывается при явном запросе от пользователя.
     * При этом сам токен будет сгенерирован повторно.
     * @param model набор данных передаваемых на фронт
     * @param principal авторизванный пользователь
     * @return - возвращает страничку профиля пользователя
     */
    String resendTokenToActivation(Model model, Principal principal);
}

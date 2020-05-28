package com.cryptowallet.services.facades;

import com.cryptowallet.entities.User;

import javax.servlet.http.HttpServletRequest;

public interface UserAuthServiceFacade {

    /**
     *  Проверяет существуют ли данные в полях lohin или Email в базе данных Пользователей.
     *
     * @param login - Строка, по замыслу хранящая Login или Email пользователя
     * @return - возвращает булиевое значение о существовании пользователя с данной записью в БД
     */
    boolean isUserExist(String login);

    /**
     * Находит пользователя по login, либо по email, которые ввел пользователь в общее поле
     *
     * @param loginOrEmail - Строка, по замыслу хранящая Login или Email пользователя
     * @return - Возвращает конкретного пользователя или  null
     */
    User findUser(String loginOrEmail);

    /**
     *  Находит пользователя по полю login
     *
     * @param login строка, хранящая login пользователя.
     * @return Возвращает конкретного пользователя или  null
     */
    User findByLogin(String login);

    /**
     *  Находит пользователя по сгенерированному токену
     *
     * @param token сгенерированный токен
     * @return Возвращает конкретного пользователя или  null
     */
    User findByToken(String token);

    /**
     *  Метод сохраняет пользователя в базу и передает управление методу loginToSite для входа на сайт.
     *
     * @param user набор данных нового пользователя
     * @param password декодированный пароль, по которому произойдет автовход
     * @param request - пробрасываемый запрос страницы. Позволит произвести вход на сайт
     */
    void createNewUser(User user, String password, HttpServletRequest request);

    /**
     *  Если пользователь еще не подтвержден - отправляет письмо с просьбой подтвердить почтовый ящик
     *
     * @param user набор данных пользователя
     */
    void sendActiveCodeToMail (User user);

    /**
     * Метод находит пользователя,
     * создает токен и ставит отметку создания токена в базу,
     * после чего токен подшивается в ссылку для восстановления пароля
     *
     * @param login - Строка, по замыслу хранящая Login или Email пользователя
     */
    void restorePassword(String login);

    /**
     *  Сохраняет пользователю новый пароль и производит подтверждение почты.
     *
     * @param user набор данных пользователя
     * @param password новый пароль в декодированном формате
     */
    void updatePassword(User user, String password);

    /**
     *  Производит подтверждение пользователя и обнуление токена
     * @param user набор данных пользователя
     */
    void activateUser(User user);

    /**
     * Производит вход на сайт по связке login-password конкретного пользователя.
     *
     * @param login логин пользователя
     * @param password декодированный пароль пользователя
     * @param request пробрасывает данные к security для входи на сайт
     */
    void loginToSite(String login, String password, HttpServletRequest request);
}

package com.yhh.practice.exception;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class CustomExceptionTest {
    public static void main(String[] args) {
        String token = login("admin1", "pass");
        System.out.println("Token: " + token);
    }

    static String login(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("password")) {
                return "token-xxxx";
            } else {
                // 抛出LoginFailedException:
                throw new LoginFailedException("Bad username or password.");
            }
        } else {
            // 抛出UserNotFoundException:
            throw new UserNotFoundException("User not found.");
        }
    }
}

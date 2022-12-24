package tictactoe.utils;

class Validators {

  static boolean isValidUsername(String username) {
    return username.length() >= 10;
  }
  
  static boolean isValidPassword(String password) {
    return password.length() >= 6;
  }
  
}

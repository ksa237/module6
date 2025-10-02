package ru.netology.module6.junittesting;

public class PasswordChecker {

    private int minLenght;
    private int maxRepeats;

    public void setMinLenght(int minLenght) throws IllegalStateException {

        if (minLenght < 0) {
            String msg = """
                    Передано неверное значение в параметр [минимальная_длина]
                    значение :""" + minLenght;
            throw new IllegalStateException(msg);
        } else
            this.minLenght = minLenght;

    }

    public void setMaxRepeats(int maxRepeats) throws IllegalStateException {

        if (maxRepeats <= 0) {
            String msg = """
                    Передано неверное значение в параметр [доп_кол_повтора_симв]
                    значение:""" + maxRepeats;
            throw new IllegalStateException(msg);
        } else
            this.maxRepeats = maxRepeats;

    }

    public boolean verify(String password) {

        if (password.length() < minLenght) {
            return false;

        }
        int count = 0;
        char previousLatter = password.charAt(0);
        for (char latter : password.toCharArray()) {
            if (latter == previousLatter) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxRepeats) {
                return false;
            }

            previousLatter = latter;
        }

        return true;

    }

}

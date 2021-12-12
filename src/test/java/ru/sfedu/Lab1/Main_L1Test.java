package ru.sfedu.Lab1;



import org.junit.Test;

import java.io.IOException;



class Main_L1Test {

    @Test
    void main() throws IOException {
        String[] args=null;
        Main_L1.main(args);
    }

    @Test
    void logBasicSystemInfo() {
        Main_L1 info = new Main_L1();
        info.logBasicSystemInfo();
    }
}
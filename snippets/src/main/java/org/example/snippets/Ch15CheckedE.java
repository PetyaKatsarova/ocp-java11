package org.example.snippets;

import java.io.*;
import java.util.*;

public class Ch15CheckedE {

    static class ExceptionCaseStudy { // cant work if nested not static: has static m.
        private static List<String> create() throws IOException {
            throw new IOException();
        }
    }
    void good() throws IOException {
        ExceptionCaseStudy.create().stream().count();
    }

    public static void main(String[] args) {
        try {
            new Ch15CheckedE().good();
        } catch (IOException e){
            System.out.println("bla bla " + e.getMessage());
        }

    }
}

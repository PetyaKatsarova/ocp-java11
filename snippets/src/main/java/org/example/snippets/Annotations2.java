package org.example.snippets;

import java.lang.annotation.Documented;

public class Annotations2 {

    enum Color {GREY, BROWN}

    @Documented
    public @interface Dirt {
        boolean wet();

        String type() ="unknown";

        public Color color();

        private static final int slippery = 5;
    }

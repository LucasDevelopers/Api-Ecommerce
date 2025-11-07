package com.lucas.api_ecommerce.utils;

public class FunctionsCpf {

    public static boolean isValidCpf(String cpf) {
        String cleanCpf = cleanCpf(cpf);

        if (cleanCpf == null) return false;

        // Verifica se todos os dígitos são iguais
        if (cleanCpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cleanCpf.charAt(i) - '0') * (10 - i);
            }

            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : 11 - resto;

            // Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cleanCpf.charAt(i) - '0') * (11 - i);
            }
            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : 11 - resto;

            // Valida os dois dígitos verificadores
            return digito1 == (cleanCpf.charAt(9) - '0') && digito2 == (cleanCpf.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
    }

    public static String cleanCpf(String cpf) {
        if (cpf == null) return null;
        String apenasNumeros = cpf.replaceAll("[^\\d]", "");
        return apenasNumeros.length() == 11 ? apenasNumeros : null;
    }

    public static String formatCpf(String cpf) {
        String cleanCpf = cleanCpf(cpf);
        if (cleanCpf == null) return null;

        return cleanCpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}

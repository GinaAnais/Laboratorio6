package ejercicio4;

import Ejercicio1.StackLink;
import Actividad1.ExceptionIsEmpty;

public class CorchetesAnidados {

    public static boolean symbolBalancing(String S) {
        // Crear una pila de tipo StackLink
        StackLink<Character> stack = new StackLink<>(S.length()); // Pasamos el tamaño máximo posible

        // Iterar sobre cada carácter de la cadena S
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // Si el carácter es un corchete de apertura, se apila
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // Si es un corchete de cierre, se verifica el balance
            else if (c == ')' || c == ']' || c == '}') {
                // Si la pila está vacía, no hay corchete abierto para emparejar
                if (stack.isEmpty()) {
                    return false;
                }

                try {
                    // Obtener el corchete de la parte superior de la pila
                    char top = stack.pop();

                    // Comprobar si el corchete de cierre corresponde al que está en la parte superior de la pila
                    if ((c == ')' && top != '(') || 
                        (c == ']' && top != '[') || 
                        (c == '}' && top != '{')) {
                        return false;
                    }
                } catch (ExceptionIsEmpty e) {
                    // Si ocurre una excepción (pila vacía cuando no debería), se devuelve false
                    return false;
                }
            }
        }

        // Al final, la pila debe estar vacía si todo está balanceado
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(symbolBalancing("()()()[()]()")); // true
        System.out.println(symbolBalancing("((()))[]"));     // true
        System.out.println(symbolBalancing("([])[]("));      // false
        System.out.println(symbolBalancing("([{)]}"));       // false
        System.out.println(symbolBalancing("["));           // false
        System.out.println(symbolBalancing("[][][]{{{}}}")); // true
    }
}

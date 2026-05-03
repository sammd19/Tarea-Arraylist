import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int na = 0, suma = 0, mayor = 0, nbuscar = 0, e = 0, nborrar = 0, temporal = 0, pares = 0, nuevo = 0;
        int nunum = 0, annum = 0, o=0,numusuarioborrar=0;
        int numestudiantes=0;
        double notasestudiantes=0;
        Scanner lector = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();//crear lista en int
        Random rand = new Random();// Para usar aleatorio

        //Crear un ArrayList de enteros con 50 números aleatorios entre (1-50) y mostrarlos.
        for (int i = 0; i < 50; i++) {
            na = rand.nextInt(50) + 1; //Crear numeros aleatorios del 1 al 50
            numeros.add(na); //Agregar el número generado a la lista
        }
        System.out.println("Lista de 50 números aleatorios:");
        System.out.println(numeros); //Mostrar la lista completa

        //Calcular la suma de los elementos de la lista.
        for (int i = 0; i < numeros.size(); i++) {
            suma += numeros.get(i); //Agarrar el valor de cada posición con get y sumar.
        }
        System.out.println("La suma de los 50 números es: " + suma);

        //Mostrar el número mayor de la lista.
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) > mayor) { //comparar para buscar el numero mayor
                mayor = numeros.get(i);
            }
        }
        System.out.println("El numero mayor de la lista es: " + mayor);

        //Buscar en la lista si el numero existe
        System.out.print("Ingrese el numero que quiera verificar ");
        nbuscar = lector.nextInt();

        for (int i = 0; i < numeros.size(); i++) {

            if (nbuscar == numeros.get(i)) {  //buscar si el numero ingresado esta en la lista
                e = 1; // si esta entonces se pondra en 1
                System.out.println("El numero " + nbuscar + " esta en la lista");
                break;
            }

        }
        if (e == 0) { //si el numero no esta se mantendra en 0
            System.out.println("El numero " + nbuscar + " no esta almacenado");
        }

        //Eliminar un elemento específico de la lista.
        System.out.print("¿Qué número quieres eliminar de la lista?: ");
        nborrar = lector.nextInt(); //Pedir numero a eliminar
        for (int i = 0; i < numeros.size(); i++) {
            if (nborrar == numeros.get(i)) {
                numeros.remove(i);// Al encontrarlo se usa remove enviando la posición 'i'
                System.out.println("El número " + nborrar + " ha sido eliminado.");
                break;// Usamos break para que solo borre la primera vez que lo encuentre
            }
        }
        System.out.println("Lista después de eliminar el numero: " + numeros);

        //Ordenar la lista de menor a mayor sin funciones
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = 0; j < numeros.size() - 1; j++) {

                if (numeros.get(j) > numeros.get(j + 1)) {
                    temporal = numeros.get(j);// Guardar numero para que no se borre
                    //Si el número de la izquierda es mayor que el de la derecha se intercambia
                    numeros.set(j, numeros.get(j + 1));
                    //Usamos .set para poner el número pequeño en la posición de la izquierda
                    //.set(posición, nuevo valor)
                    numeros.set(j + 1, temporal);
                    //Ahora ponemos el número que guardamos en la posición de la derecha
                }
            }
        }
        System.out.println("Lista ordenada de menor a mayor:");
        System.out.println(numeros); //Se muestra la lista ordenada

        //Contar cuántos números son pares dentro de la lista
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {// Si el residuo es 0, significa que el número es par
                pares += 1;// Si es par se suma 1 al contador
            }
        }
        System.out.println("En la lista hay un total de " + pares + " números pares.");

        //Crear un CRUD básico usando ArrayList (agregar, listar, eliminar, actualizar)
        while (o != 5) {
            System.out.println("""
        Bienvenido al CRUD cual opcion desea?);
        1. Agregar
        2. Listar
        3. Eliminar
        4. Actualizar
        5. Continuar con el codigo
        Seleccione una opción: """);
            o = lector.nextInt();
            switch (o) {
                case 1:
                    //Agregar numero
                    o = Integer.parseInt("1");
                    System.out.println("Ingrese un número para agregar al final: ");
                    nuevo = lector.nextInt();
                    numeros.add(nuevo); // Comando .add para agregar
                    System.out.println("Número agregado");
                    break;
                case 2:
                    //Mostrar lista actual
                    o = Integer.parseInt("2");
                    System.out.println("Lista actual de números:");
                    System.out.println(numeros); //Imprimir la lista actual
                    System.out.println();
                    break;
                case 3:
                    //Eliminar numero
                    o = Integer.parseInt("3");
                    System.out.print("¿Qué número quieres eliminar?: ");
                    numusuarioborrar = lector.nextInt();
                    boolean eliminado = false;
                    for (int i = 0; i < numeros.size(); i++) {
                        if (numeros.get(i) == numusuarioborrar) {
                            numeros.remove(i); // Borramos la posición i
                            eliminado = true;
                            System.out.println("Eliminado");
                            break;
                        }
                    }
                    if(eliminado == false){
                        System.out.println("No existe");
                    }
                    break;
                case 4:
                    //Actualizar numero
                    o = Integer.parseInt("4");
                    System.out.println("Que numero desea cambiar: ");
                    annum = lector.nextInt();
                    System.out.print("Ingrese el nuevo valor para reemplazarlo: ");
                    nunum = lector.nextInt();
                    boolean numcambiado = false; //Aca esta en que no lo tiene
                    for (int i = 0; i < numeros.size(); i++) {
                        if (numeros.get(i) == annum) { //Si un numero de la lista es igual al que quiere cambiar
                            numeros.set(i, nunum); //Entonces se cambia ese por el nuevo numero
                            numcambiado = true; // asi entonces ya lo tiene
                            System.out.println("Número actualizado");
                            break;
                        }
                    }
                    if (numcambiado == false) {
                        System.out.println("El número " + annum + " no se encontró en la lista.");
                    }
                    break;
                case 5: // Seguir
                    o = Integer.parseInt("5");
                    System.out.println("Continuando con el programa.");
                    break;
            }    }


        // Crear una lista de objetos (ej: Estudiante con nombre y nota) y mostrar los datos.
        // Creamos dos listas una para los nombres y otra para las notas
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();

        System.out.print("¿Cuántos estudiantes vas a registrar?: ");
        numestudiantes = lector.nextInt();
        lector.nextLine(); // Deje escribir nombres después del número

        //Pedimos los datos al usuario
        for (int i = 0; i < numestudiantes; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            String nom = lector.nextLine(); // El usuario escribe el nombre
            nombres.add(nom); // Guardamos el nombre en su lista

            System.out.print("Nota de " + nom + ": ");
            notasestudiantes = lector.nextDouble(); // El usuario escribe la nota
            notas.add(notasestudiantes); // Guardamos la nota en su lista
            lector.nextLine();
        }

        //Mostrar los datos
        System.out.println("Listado de estudiantes");
        for (int i = 0; i < nombres.size(); i++) {
            // Usamos el mismo índice 'i' para sacar el nombre de una lista y la nota de la otra
            System.out.println("Estudiante: " + nombres.get(i) + ", Nota: " + notas.get(i));
        }

    }
}
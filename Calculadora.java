import java.awt.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import javax.swing.JOptionPane;
//import org.w3c.dom.Text;

/**
 * Realiza las operaciones básicas de una calculadora:
 * suma, resta, multiplicar y dividir.
 *
 * @author jvf350
 * @version "25/02/24"
 * */
public class Calculadora {

    //Constantes
    final int MAX_DIGITS = 5;
    final int MODE_ENTRADA = 0;
    final int MODE_RESULTADO = 1;


    //Variables
    int modo;
    int digito;
    int valor1;
    int valor2;
    String operacion;
    boolean inicializa_resultado;
    private static Text texto_resultado;



    /**
     * Contiene el método {@link #inicializa()} y una condición para
     * que el método {@link #dibujaCalculadora()} actúe.
     *
     * @param gui Si es true, dibuja la Interfaz Gráfica de Usuario,
     * si es false no lo hace.
     * */
    public Calculadora(boolean gui) {
        //Inicialización de las variables.
        inicializa();

        if (gui==true) dibujaCalculadora();

    }

    /**
     * Crea la interfaz gráfica de usuario de la calculadora
     * usando componentes SWT:
     * <ul>
     *      <li>
     *      {@link Display#getDefault()} constructor de la pantalla,
     *      sobre la que se construye la interfaz.
     *      </li>
     *      <li>
     *      {@link Shell} constructor que crea la interfaz de
     *      la Calculadora.
     *      </li>
     *      <li>
     *      {@link Button} crea un botón para cada número, tipo de
     *      cálculo y de obtener resultado. Los botones contienen unos
     *      receptores {@link org.eclipse.swt.events.SelectionListener}.
     *      </li>
     * </ul>
     *
     *  Tiene un ciclo {@code while (!shlCalculadora.isDisposed())} para que la
     *  calculadora lea continuamente eventos, pero cuando no haya, quede suspendida
     *  {@code display.sleep()}.
     * <br/>
     * También hay un área {@code texto_resultado} donde aparecen lo introducido y el resultado.
     *
     * @throws NumberFormatException Puede ocurrir si falla la inicialización de la GUI.
     * @see <a href=https://download.eclipse.org/rt/rap/doc/2.3/guide/reference/api/org/eclipse/swt/widgets/Button.html#addSelectionListener(org.eclipse.swt.events.SelectionListener)/>SelectionListener
     * @see <a href="https://download.eclipse.org/rt/rap/doc/3.3/guide/reference/api/org/eclipse/swt/widgets/Display.html"/>Clase Display
     * @see <a href="https://download.eclipse.org/rt/rap/doc/2.3/guide/reference/api/org/eclipse/swt/widgets/Shell.html"/>Clase Shell
     * @see <a href="https://download.eclipse.org/rt/rap/doc/2.3/guide/reference/api/org/eclipse/swt/widgets/Button.html"/> Clase Button
     */
    private void dibujaCalculadora() {

        Display display = Display.getDefault();
        Shell shlCalculadora = new Shell();
        shlCalculadora.setSize(259, 250);
        shlCalculadora.setText("Calculadora");


        //------------------------------------------------ -
        //Números
        //------------------------------------------------ -


        //botón con el número 0
        Button button_0 = new Button(shlCalculadora, SWT.NONE);
        button_0.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(0);
            }
        });
        button_0.setText("0");
        button_0.setBounds(23, 163, 40, 33);

        //botón con el número 1
        Button button_1 = new Button(shlCalculadora, SWT.NONE);
        button_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(1);
            }
        });
        button_1.setText("1");
        button_1.setBounds(23, 124, 40, 33);

        //botón con el número 2
        Button button_2 = new Button(shlCalculadora, SWT.NONE);
        button_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(2);
            }
        });
        button_2.setText("2");
        button_2.setBounds(69, 124, 40, 33);

        //botón con el número 3
        Button button_3 = new Button(shlCalculadora, SWT.NONE);
        button_3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(3);
            }
        });
        button_3.setText("3");
        button_3.setBounds(115, 124, 40, 33);

        //botón con el número 4
        Button button_4 = new Button(shlCalculadora, SWT.NONE);
        button_4.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(4);
            }
        });
        button_4.setText("4");
        button_4.setBounds(23, 85, 40, 33);

        //botón con el número 5
        Button button_5 = new Button(shlCalculadora, SWT.NONE);
        button_5.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(5);
            }
        });
        button_5.setText("5");
        button_5.setBounds(69, 85, 40, 33);

        //botón con el número 6
        Button button_6 = new Button(shlCalculadora, SWT.NONE);
        button_6.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(6);
            }
        });
        button_6.setText("6");
        button_6.setBounds(115, 85, 40, 33);

        //botón con el número 7
        Button button_7 = new Button(shlCalculadora, SWT.NONE);
        button_7.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(7);
            }
        });
        button_7.setText("7");
        button_7.setBounds(23, 46, 40, 33);

        //botón con el número 8
        Button button_8 = new Button(shlCalculadora, SWT.NONE);
        button_8.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(8);
            }
        });
        button_8.setBounds(69, 46, 40, 33);
        button_8.setText("8");

        //botón con el número 9
        Button button_9 = new Button(shlCalculadora, SWT.NONE);
        button_9.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(9);
            }
        });
        button_9.setText("9");
        button_9.setBounds(115, 46, 40, 33);


        //------------------------------------------------ -
        //Operaciones
        //------------------------------------------------ -

        //botón con la operacion de división
        Button button_12 = new Button(shlCalculadora, SWT.NONE);
        button_12.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("/");
            }
        });
        button_12.setText("/");
        button_12.setBounds(178, 46, 40, 33);

        //botón con la operacion de multiplicación
        Button button_13 = new Button(shlCalculadora, SWT.NONE);
        button_13.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("*");
            }
        });
        button_13.setText("*");
        button_13.setBounds(178, 85, 40, 33);

        //botón con la operacion de suma
        Button button_14 = new Button(shlCalculadora, SWT.NONE);
        button_14.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("+");
            }
        });
        button_14.setText("+");
        button_14.setBounds(178, 124, 40, 33);

        //botón con la operacion de resto
        Button button_15 = new Button(shlCalculadora, SWT.NONE);
        button_15.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("-");
            }
        });
        button_15.setText("-");
        button_15.setBounds(178, 163, 40, 33);

        //botón con la operacion de igual
        Button button_11 = new Button(shlCalculadora, SWT.NONE);
        button_11.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarIgual();
            }
        });
        button_11.setText("=");
        button_11.setBounds(69, 163, 86, 33);


        //Texto donde se visualiza el resultado
        texto_resultado = new Text(shlCalculadora, SWT.BORDER);
        texto_resultado.setText("0");
        texto_resultado.setBounds(22, 19, 196, 21);

        shlCalculadora.open();
        shlCalculadora.layout();
        while (!shlCalculadora.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Método de inicialización de variables, que
     * crea un estado predeterminado en la calculadora.<br/>
     * <ul>
     *     <li>{@code operacion} establece el tipo de operación (suma, resta,...).</li>
     *     <li>{@code valor1, valor2} inicializa los operandos.</li>
     *     <li>{@code modo = MODE_ENTRADA} modo en el que entra la calculadora
     *     para que se intrduzcan datos.</li>
     * </ul>
     *
     */
    public void inicializa() {
        operacion = "null";
        valor1 = 0;
        valor2 = 0;
        modo = MODE_ENTRADA;
        inicializa_resultado = true;
    }

    /**
     * Getter para obtener el resultado como una cadena de texto.
     *
     * @return El resultado como cadena de texto.
     */
    public String getResultadoString (){
        return texto_resultado.getText();
    }

    /**
     * Setter para establecer el resultado como una cadena de texto.
     *
     * @param s La cadena de texto que se establecerá como resultado.
     */
    public void setResultadoString(String s){
        texto_resultado.setText(s);
    }

    /**
     * Método para pasar el resultado de tipo cadena de texto a entero.
     *
     * @return El resultado como un entero.
     */
    public int getResultadoInt() {
        String resultado = texto_resultado.getText();
        return Integer.parseInt(resultado);
    }

    /**
     * Método para añadir un nuevo dígito a la entrada.<br/>
     * <ul>
     * <li>{@code if (inputString.indexOf("0") == 0)} simplifica
     * los ceros a la izquierda.</li>
     * <li>{@code inputString.length() < MAX_DIGITS)} pone como condición,
     * para introducir dígitos, que la cifra completa introducida no
     * sea mayor a {@code MAX_DIGITS}.</li>
     * <li>{@code (!inputString.equals("0") || digito > 0)} hace que los dígitos
     * menos el cero se agreguen al {@link #getResultadoString()},
     * uno detrás de otro dígito pues se trata de una cadena de texto.</li>
     * <li>{@code inicializa_resultado = false} para poder agregar dígitos
     * a la cifra, siempre hasta el máximo de longitud.</li>
     *</ul>
     *
     * @param digito El dígito introducido por el usuario.
     */
    public void anadeNuevoDigito(int digito){
        if (inicializa_resultado)
            setResultadoString("");

        String inputString = getResultadoString();

        if (inputString.indexOf("0") == 0){
            inputString = inputString.substring(1);
        }

        if ((!inputString.equals("0") || digito > 0) && inputString.length() < MAX_DIGITS){
            setResultadoString(inputString + digito);
        }

        modo = MODE_ENTRADA;
        inicializa_resultado = false;
    }

    /**
     * Método para ejecutar una operación.<br/>
     * <ul>
     * <li>{@code if (operacion.equals("null"))} hace que no se
     * ejecute si no se indica una operación tras el {@code valor1},
     * que en principio se le asigna valor {@code resultado}.</li>
     * <li>Si se indica operación, {@code valor2} es asignado como {@code resultado}.</li>
     * <li>{@code inicializa_resultado = true} indica que la operación finalizó,
     * para que la siguiente entrada genere un nuevo cálculo.</li>
     * <li>{@code operacion = new operacion} Reanuda la operación.</li>
     * <li>Se ejecuta resultado y se muestra en la interfaz con {@link #ejecutarOperacion()} y
     * {@link #muestraResultado(int)}.</li>
     * </ul>
     *
     * @param new_operacion La operación nueva que se va a ejecutar.
     * @throws NumberFormatException Si el resultado no se puede convertir a un entero.
     */
    public void ejecutarOperador(String new_operacion) {

        int resultado;

        if (operacion.equals("null"))
        {
            resultado = getResultadoInt();
            valor1 = resultado;
        }

        else
        {
            valor2 = getResultadoInt();
            resultado = ejecutarOperacion();
            muestraResultado(resultado);
            valor1 = resultado;
        }

        inicializa_resultado = true;
        operacion = new_operacion;
    }

    /**
     * Método para ejecutar la operación de igual.
     */
    public void ejecutarIgual(){
        int resultado = 0;

        valor2 = getResultadoInt();
        resultado = ejecutarOperacion();
        muestraResultado(resultado);

        operacion = "null";
    }

    /**
     * Método para ejecutar una operación según el símbolo
     * matemático seleccionado.<br/>
     * <br/>
     * Un {@link JOptionPane#showMessageDialog(Component, Object)} lanzará un
     * mensaje de error si se introduce un denominador 0 en la división.
     *
     * @deprecated Las herramientas para crear GUI de SWT
     * no deben usarse con otras como {@link javax.swing}, pues pueden tener
     * errores de compatibilidad en funcionamiento y apariencia.
     * Use en su lugar {@link org.eclipse.swt.widgets.MessageBox}
     * @return El resultado.
     * @throws ArithmeticException Si en una división el denominador es cero.
     */
    public int ejecutarOperacion() {
        int resultado = 0;

        if (operacion.equals("/"))
        {

            if (valor2 == 0)
            {
                JOptionPane.showMessageDialog(null, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                operacion = "null";
                valor1 = 0;
                modo = MODE_ENTRADA;
                inicializa_resultado = true;
            }
            else
                resultado = valor1 / valor2;
        }

        if (operacion.equals("*"))
            resultado = valor1 * valor2;

        if (operacion.equals("-"))
            resultado = valor1 - valor2;

        if (operacion.equals("+"))
            resultado = valor1 + valor2;

        return resultado;
    }

    /**
     * Método que muestra el resultado en pantalla como un tipo String.
     * Se activa el {@link #modo} resultado.
     *
     * @param resultado El resultado de la operación.
     */
    public void muestraResultado(int resultado){
        setResultadoString(Integer.toString(resultado));
        valor1 = resultado;
        modo = MODE_RESULTADO;
        inicializa_resultado = true;
    }

    /**
     * Método main para ejecutar la calculadora.
     */
    public static void main(String args[]) {
        Calculadora calculadora = new Calculadora(true);
    }

}

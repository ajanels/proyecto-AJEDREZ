/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import movimientos.movimientosb;
import movimientos.movimientosj;
import proyecto_ajedrez.perdiste;
import proyecto_ajedrez.eleccion;
import proyecto_ajedrez.TABLA;
import proyecto_ajedrez.inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Controlador implements ActionListener {
    
    public static boolean enrroqueReyA = true;
    public static boolean enrroqueTorreIzquierdaA = true;
    public static boolean enrroqueTorreDerechaA = true;
    public static boolean enrroqueReyB = true;
    public static boolean enrroqueTorreIzquierdaB = true;
    public static boolean enrroqueTorreDerechaB = true;

    public static String[][] tablero = new String[8][8];
    private char turnoJugador = 'A';
    private String posicionAntigua = null;
    private String posicionNueva = null;
    private String posicionActual;
    public static String fichaElegida;
    public static ImageIcon imagenElegida;
    movimientosj Movimientosj;
    movimientosb movimientosb = new movimientosb();
    
    public Controlador() {
        iniciarTablero();
            TABLA vista = new TABLA();
        vista.setVisible(true);
        añadirActionEvents();
        Movimientosj = new movimientosj();
    }

    private void iniciarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = "";
            }
        }

        for (int i = 0; i < 8; i++) {
            tablero[1][i] = "B_peon";
            tablero[6][i] = "A_peon";
        }

        tablero[0][0] = "B_torre";
        tablero[0][1] = "B_caballo";
        tablero[0][2] = "B_alfil";
        tablero[0][3] = "B_reina";
        tablero[0][4] = "B_rey";
        tablero[0][5] = "B_alfil";
        tablero[0][6] = "B_caballo";
        tablero[0][7] = "B_torre";

        tablero[7][0] = "A_torre";
        tablero[7][1] = "A_caballo";
        tablero[7][2] = "A_alfil";
        tablero[7][3] = "A_reina";
        tablero[7][4] = "A_rey";
        tablero[7][5] = "A_alfil";
        tablero[7][6] = "A_caballo";
        tablero[7][7] = "A_torre";
    }

    private void añadirActionEvents() {
        TABLA.c1.addActionListener(this);
        TABLA.c2.addActionListener(this);
        TABLA.c3.addActionListener(this);
        TABLA.c4.addActionListener(this);
        TABLA.c5.addActionListener(this);
        TABLA.c6.addActionListener(this);
        TABLA.c7.addActionListener(this);
        TABLA.c8.addActionListener(this);
        
        TABLA.c9.addActionListener(this);
        TABLA.c10.addActionListener(this);
        TABLA.c11.addActionListener(this);
        TABLA.c12.addActionListener(this);
        TABLA.c13.addActionListener(this);
        TABLA.c14.addActionListener(this);
        TABLA.c15.addActionListener(this);
        TABLA.c16.addActionListener(this);
        
        TABLA.c17.addActionListener(this);
        TABLA.c18.addActionListener(this);
        TABLA.c19.addActionListener(this);
        TABLA.c20.addActionListener(this);
        TABLA.c21.addActionListener(this);
        TABLA.c22.addActionListener(this);
        TABLA.c23.addActionListener(this);
        TABLA.c24.addActionListener(this);
        
        TABLA.c25.addActionListener(this);
        TABLA.c26.addActionListener(this);
        TABLA.c27.addActionListener(this);
        TABLA.c28.addActionListener(this);
        TABLA.c29.addActionListener(this);
        TABLA.c30.addActionListener(this);
        TABLA.c31.addActionListener(this);
        TABLA.c32.addActionListener(this);
        
        TABLA.c33.addActionListener(this);
        TABLA.c34.addActionListener(this);
        TABLA.c35.addActionListener(this);
        TABLA.c36.addActionListener(this);
        TABLA.c37.addActionListener(this);
        TABLA.c38.addActionListener(this);
        TABLA.c39.addActionListener(this);
        TABLA.c40.addActionListener(this);
        
        TABLA.c41.addActionListener(this);
        TABLA.c42.addActionListener(this);
        TABLA.c43.addActionListener(this);
        TABLA.c44.addActionListener(this);
        TABLA.c45.addActionListener(this);
        TABLA.c46.addActionListener(this);
        TABLA.c47.addActionListener(this);
        TABLA.c48.addActionListener(this);
        
        TABLA.c49.addActionListener(this);
        TABLA.c50.addActionListener(this);
        TABLA.c51.addActionListener(this);
        TABLA.c52.addActionListener(this);
        TABLA.c53.addActionListener(this);
        TABLA.c54.addActionListener(this);
        TABLA.c55.addActionListener(this);
        TABLA.c56.addActionListener(this);
        
        TABLA.c57.addActionListener(this);
        TABLA.c58.addActionListener(this);
        TABLA.c59.addActionListener(this);
        TABLA.c60.addActionListener(this);
        TABLA.c61.addActionListener(this);
        TABLA.c62.addActionListener(this);
        TABLA.c63.addActionListener(this);
        TABLA.c64.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (turnoJugador == 'A') {
            posicionActual = getBotonPosicionString(ae.getSource());

            if (comprobarSiLaFichaEsBlanca(posicionActual)) {
                posicionAntigua = posicionActual;
            } else if (posicionAntigua != null) {
                posicionNueva = posicionActual;
                if (Movimientosj.esPosibleEsteMovimieSnto(tablero, posicionAntigua, posicionNueva)){
                    cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                    turnoMaquina();
                    comprobarJaqueMateHaciaBlancas();
                }
            }
        }
    }
    
    private void comprobarJaqueMateHaciaBlancas(){
        boolean jaqueMate = true;
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                String posicion = ""+i+""+j;
                if(comprobarSiLaFichaEsBlanca(posicion)){
                    String[] movimientosF = Movimientosj.movimientosAmodificados(tablero, posicion);
                    if(!movimientosF[0].equals("")){
                        jaqueMate = false;
                        break;
                    }
                }
            }
        }
        
        if(jaqueMate == true){
            perdiste ventana = new perdiste(null, true);
            ventana.setVisible(true);
        }
        
    }
    
    private void turnoMaquina(){
            String[] movimientos = movimientosb.movimientoBot(tablero);
            cambiarFichas(movimientos[0], movimientos[1]);
    }
    
    
    private void cambiarFichas(String posAntigua, String posNueva) {
        cambiarEnString(posAntigua, posNueva);
        cambiarEnPantalla(posAntigua, posNueva);
        comprobarPeonEnUltimaFila();
        comprobarEnrroque(posAntigua, posNueva);
    }

    private void cambiarEnString(String posAntigua, String posNueva) {
        int xA = Character.getNumericValue(posAntigua.charAt(1));
        int yA = Character.getNumericValue(posAntigua.charAt(0));

        int xN = Character.getNumericValue(posNueva.charAt(1));
        int yN = Character.getNumericValue(posNueva.charAt(0));
               
        tablero[yN][xN] = tablero[yA][xA];
        tablero[yA][xA] = "";
    }

    private void cambiarEnPantalla(String posAntigua, String posNueva) {
        boton(posNueva).setIcon(boton(posAntigua).getIcon());
        boton(posAntigua).setIcon(null);
    }

    private void comprobarPeonEnUltimaFila() {
        for (int i = 0; i < 8; i++) {
            if (tablero[0][i].equals("A_peon")) {
                //Se mostrara la tabla de eleccion de ficha
                eleccionDePeon();
                tablero[0][i] = fichaElegida;
                String posicion = "0" + i;
                boton(posicion).setIcon(imagenElegida);
            }

            if (tablero[7][i].equals("B_peon")) {
                tablero[7][i] = "B_reina";
                String posicion = "7" + i;
                boton(posicion).setIcon(new ImageIcon(getClass().getResource("/Imagenes/ReinaNegra.png")));
            }
        }
    }

    private void eleccionDePeon() {
         eleccion sa=new eleccion(null,true);
         sa.setVisible(true);
    }

    private void comprobarEnrroque(String posAntigua, String posNueva) {
        int xN = Character.getNumericValue(posNueva.charAt(1));
        int yN = Character.getNumericValue(posNueva.charAt(0));

        int xA = Character.getNumericValue(posAntigua.charAt(1));
        int yA = Character.getNumericValue(posAntigua.charAt(0));

        if (tablero[yN][xN].equals("A_rey") || tablero[yN][xN].equals("B_rey")) {
            if (xA + 2 == xN) {
                //Derecha
                tablero[yN][xN - 1] = tablero[yN][7];
                tablero[yN][xN + 1] = "";

                String posicionTorreAntigua = "" + yN + 7;
                String posicionTorreNueva = "" + yN + (xN - 1);

                boton(posicionTorreNueva).setIcon(boton(posicionTorreAntigua).getIcon());
                boton(posicionTorreAntigua).setIcon(null);
            } else if (xA - 2 == xN) {
                //Izquierda
                tablero[yN][xA - 1] = tablero[yN][0];
                tablero[yN][0] = "";

                String posicionTorreAntigua = "" + yN + 0;
                String posicionTorreNueva = "" + yN + (xA - 1);

                boton(posicionTorreNueva).setIcon(boton(posicionTorreAntigua).getIcon());
                boton(posicionTorreAntigua).setIcon(null);
            }
        }
    }

    private JButton boton(String posicion) {
        if (posicion.equals("00")) {
            return TABLA.c1;
        } else if (posicion.equals("01")) {
            return TABLA.c2;
        } else if (posicion.equals("02")) {
            return TABLA.c3;
        } else if (posicion.equals("03")) {
            return TABLA.c4;
        } else if (posicion.equals("04")) {
            return TABLA.c5;
        } else if (posicion.equals("05")) {
            return TABLA.c6;
        } else if (posicion.equals("06")) {
            return TABLA.c7;
        } else if (posicion.equals("07")) {
            return TABLA.c8;
        } else if (posicion.equals("08")) {
            return TABLA.c9;
        } else if (posicion.equals("9")) {
            return TABLA.c10;
        } else if (posicion.equals("10")) {
            return TABLA.c11;
        } else if (posicion.equals("11")) {
            return TABLA.c12;
        } else if (posicion.equals("12")) {
            return TABLA.c13;
        } else if (posicion.equals("13")) {
            return TABLA.c14;
        } else if (posicion.equals("14")) {
            return TABLA.c15;
        } else if (posicion.equals("15")) {
            return TABLA.c16;
        } else if (posicion.equals("16")) {
            return TABLA.c17;
        } else if (posicion.equals("17")) {
            return TABLA.c18;
        } else if (posicion.equals("18")) {
            return TABLA.c19;
        } else if (posicion.equals("19")) {
            return TABLA.c20;
        } else if (posicion.equals("20")) {
            return TABLA.c21;
        } else if (posicion.equals("21")) {
            return TABLA.c22;
        } else if (posicion.equals("22")) {
            return TABLA.c23;
        } else if (posicion.equals("23")) {
            return TABLA.c24;
        } else if (posicion.equals("24")) {
            return TABLA.c25;
        } else if (posicion.equals("25")) {
            return TABLA.c26;
        } else if (posicion.equals("26")) {
            return TABLA.c27;
        } else if (posicion.equals("27")) {
            return TABLA.c28;
        } else if (posicion.equals("28")) {
            return TABLA.c29;
        } else if (posicion.equals("39")) {
            return TABLA.c30;
        } else if (posicion.equals("30")) {
            return TABLA.c31;
        } else if (posicion.equals("31")) {
            return TABLA.c32;
        } else if (posicion.equals("32")) {
            return TABLA.c33;
        } else if (posicion.equals("33")) {
            return TABLA.c34;
        } else if (posicion.equals("34")) {
            return TABLA.c35;
        } else if (posicion.equals("35")) {
            return TABLA.c36;
        } else if (posicion.equals("36")) {
            return TABLA.c37;
        } else if (posicion.equals("37")) {
            return TABLA.c38;
        } else if (posicion.equals("38")) {
            return TABLA.c39;
        } else if (posicion.equals("49")) {
            return TABLA.c40;
        } else if (posicion.equals("40")) {
            return TABLA.c41;
        } else if (posicion.equals("41")) {
            return TABLA.c42;
        } else if (posicion.equals("42")) {
            return TABLA.c43;
        } else if (posicion.equals("43")) {
            return TABLA.c44;
        } else if (posicion.equals("44")) {
            return TABLA.c45;
        } else if (posicion.equals("45")) {
            return TABLA.c46;
        } else if (posicion.equals("46")) {
            return TABLA.c47;
        } else if (posicion.equals("47")) {
            return TABLA.c48;
        } else if (posicion.equals("48")) {
            return TABLA.c49;
        } else if (posicion.equals("49")) {
            return TABLA.c50;
        } else if (posicion.equals("50")) {
            return TABLA.c51;
        } else if (posicion.equals("51")) {
            return TABLA.c52;
        } else if (posicion.equals("52")) {
            return TABLA.c53;
        } else if (posicion.equals("53")) {
            return TABLA.c54;
        } else if (posicion.equals("54")) {
            return TABLA.c55;
        } else if (posicion.equals("55")) {
            return TABLA.c56;
        } else if (posicion.equals("56")) {
            return TABLA.c57;
        }else if (posicion.equals("57")) {
            return TABLA.c58;
        } else if (posicion.equals("58")) {
            return TABLA.c59; 
        } else if (posicion.equals("59")) {
            return TABLA.c60;
        } else if (posicion.equals("60")) {
            return TABLA.c61;
        } else if (posicion.equals("61")) {
            return TABLA.c62;
        } else if (posicion.equals("62")) {
            return TABLA.c63;
        } else if (posicion.equals("63")) {
            return TABLA.c64;
        } 
        return null;
    }

    private String getBotonPosicionString(Object boton) {
        if (boton == TABLA.c1) {
            return "00";
        } else if (boton == TABLA.c2) {
            return "01";
        } else if (boton == TABLA.c3) {
            return "02";
        } else if (boton == TABLA.c4) {
            return "03";
        } else if (boton == TABLA.c5) {
            return "04";
        } else if (boton == TABLA.c6) {
            return "05";
        } else if (boton == TABLA.c7) {
            return "06";
        } else if (boton == TABLA.c8) {
            return "07";
        } else if (boton == TABLA.c9) {
            return "08";
        } else if (boton == TABLA.c10) {
            return "9";
        } else if (boton == TABLA.c11) {
            return "10";
        } else if (boton == TABLA.c12) {
            return "11";
        } else if (boton == TABLA.c13) {
            return "12";
        } else if (boton == TABLA.c14) {
            return "13";
        } else if (boton == TABLA.c15) {
            return "14";
        } else if (boton == TABLA.c16) {
            return "15";
        } else if (boton == TABLA.c17) {
            return "16";
        } else if (boton == TABLA.c18) {
            return "17";
        } else if (boton == TABLA.c19) {
            return "18";
        } else if (boton == TABLA.c20) {
            return "19";
        } else if (boton == TABLA.c21) {
            return "20";
        } else if (boton == TABLA.c22) {
            return "21";
        } else if (boton == TABLA.c23) {
            return "22";
        } else if (boton == TABLA.c24) {
            return "23";
        } else if (boton == TABLA.c25) {
            return "24";
        } else if (boton == TABLA.c26) {
            return "25";
        } else if (boton == TABLA.c27) {
            return "26";
        } else if (boton == TABLA.c28) {
            return "27";
        } else if (boton == TABLA.c29) {
            return "28";
        } else if (boton == TABLA.c30) {
            return "29";
        } else if (boton == TABLA.c31) {
            return "30";
        } else if (boton == TABLA.c32) {
            return "31";
        } else if (boton == TABLA.c33) {
            return "32";
        } else if (boton == TABLA.c34) {
            return "33";
        } else if (boton == TABLA.c35) {
            return "34";
        } else if (boton == TABLA.c36) {
            return "35";
        } else if (boton == TABLA.c37) {
            return "36";
        } else if (boton == TABLA.c38) {
            return "37";
        } else if (boton == TABLA.c39) {
            return "38";
        } else if (boton == TABLA.c40) {
            return "39";
        } else if (boton == TABLA.c41) {
            return "40";
        } else if (boton == TABLA.c42) {
            return "41";
        } else if (boton == TABLA.c43) {
            return "42";
        } else if (boton == TABLA.c44) {
            return "43";
        } else if (boton == TABLA.c45) {
            return "44";
        } else if (boton == TABLA.c46) {
            return "45";
        } else if (boton == TABLA.c47) {
            return "46";
        } else if (boton == TABLA.c48) {
            return "47";
        } else if (boton == TABLA.c49) {
            return "48";
        } else if (boton == TABLA.c50) {
            return "49";
        } else if (boton == TABLA.c51) {
            return "50";
        } else if (boton == TABLA.c52) {
            return "51";
        } else if (boton == TABLA.c53) {
            return "52";
        } else if (boton == TABLA.c54) {
            return "53";
        } else if (boton == TABLA.c55) {
            return "54";
        } else if (boton == TABLA.c56) {
            return "55";
        } else if (boton == TABLA.c57) {
            return "56";
        } else if (boton == TABLA.c58) {
            return "57";
        } else if (boton == TABLA.c59) {
            return "58";
        } else if (boton == TABLA.c60) {
            return "59";
        } else if (boton == TABLA.c61) {
            return "60";
        } else if (boton == TABLA.c62) {
            return "61";
        } else if (boton == TABLA.c63) {
            return "62";
        } else if (boton == TABLA.c64) {
            return "63";
        } 
        return null;
    }

    private boolean comprobarSiLaFichaEsBlanca(String posicion) {
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0) == 'A') ? true : false;
        }
        return false;
    }

}
   


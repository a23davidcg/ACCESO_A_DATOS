package Ejercicio_ClasificacionDAO;

public class Clasificacion {

        private String equipo;
        private int puntos;
        private int partidosJugados;

        // Constructores, getters y setters

        public Clasificacion(String equipo, int puntos, int partidosJugados) {
            this.equipo = equipo;
            this.puntos = puntos;
            this.partidosJugados = partidosJugados;
        }

        public String getEquipo() {
            return equipo;
        }

        public void setEquipo(String equipo) {
            this.equipo = equipo;
        }

        public int getPuntos() {
            return puntos;
        }

        public void setPuntos(int puntos) {
            this.puntos = puntos;
        }

        public int getPartidosJugados() {
            return partidosJugados;
        }

        public void setPartidosJugados(int partidosJugados) {
            this.partidosJugados = partidosJugados;
        }
    }



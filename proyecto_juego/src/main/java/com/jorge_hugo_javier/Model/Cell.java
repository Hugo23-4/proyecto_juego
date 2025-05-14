package com.jorge_hugo_javier.Model;

/**
 * Representa una celda del mapa del juego.
 * Puede ser de tipo pared, suelo o trampa, y puede contener un ocupante.
 */
public class Cell {
    /**
     * Tipos posibles de celda en el mapa: pared, suelo o trampa.
     */
    public enum Type {
        WALL,   // No transitables
        FLOOR,  // Transitables sin daño
        TRAP    // Transitables, pero infligen daño
    }

    // Tipo de esta celda
    private Type type;
    // Personaje que ocupa la celda (null si está vacía)
    private JuegoCharacter occupant;
    // Símbolo original que representa esta celda en el mapa de texto
    private char simboloOriginal;

    /**
     * Constructor de la celda, recibe su tipo y símbolo original.
     */
    public Cell(Type type, char simboloOriginal) {
        this.type = type;
        this.simboloOriginal = simboloOriginal;
        this.occupant = null;
    }

    // --- Getters y Setters ---

    /**
     * Devuelve el tipo de la celda.
     */
    public Type getType() {
        return type;
    }

    /**
     * Asigna un nuevo tipo a la celda.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Obtiene el ocupante actual de la celda (puede ser null).
     */
    public JuegoCharacter getOccupant() {
        return occupant;
    }

    /**
     * Fija el ocupante de la celda (personaje o null).
     */
    public void setOccupant(JuegoCharacter occupant) {
        this.occupant = occupant;
    }

    /**
     * Devuelve el símbolo original (char) usado al cargar el mapa.
     */
    public char getSimboloOriginal() {
        return simboloOriginal;
    }

    // --- Lógica de transitabilidad ---

    /**
     * Indica si la celda es transitable.
     * Se puede caminar si es suelo o trampa y no hay ocupante vivo.
     */
    public boolean isWalkable() {
        boolean esTipoPermitido = (type == Type.FLOOR || type == Type.TRAP);
        boolean sinOcupanteVivo = (occupant == null || occupant.isDead());
        return esTipoPermitido && sinOcupanteVivo;
    }
}
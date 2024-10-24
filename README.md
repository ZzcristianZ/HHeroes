Descripción General
Este programa simula un juego de combate por turnos en el terminal, donde el jugador puede elegir entre ser un héroe (Goku) o un villano (Zamasu) y enfrentarse a un jefe (Jiren). El jugador y el jefe pueden usar ataques regulares, bonificaciones y habilidades especiales durante el combate.

Variables Globales
vidaHeroe: Puntos de vida del héroe (inicialmente 100).

vidaVillano: Puntos de vida del villano (inicialmente 150).

vidaJefe: Puntos de vida del jefe (inicialmente 200).

personajeSeleccionado: Almacena el nombre del personaje elegido por el jugador (Goku o Zamasu).

random: Instancia de la clase Random para generar acciones aleatorias del jefe.

usosBonusJugador: Veces que el jugador puede usar el bonus de curación (inicialmente 2).

usosBonusJefe: Veces que el jefe puede usar el bonus de curación (inicialmente 2).

usosBonusDañoJugador: Veces que el jugador puede usar el bonus de daño (inicialmente 2).

usosBonusDañoJefe: Veces que el jefe puede usar el bonus de daño (inicialmente 2).

dañoAdicionalJefe: Daño adicional del jefe acumulado por usar bonus de daño.

dañoAdicionalJugador: Daño adicional del jugador acumulado por usar bonus de daño.

usosHabilidadEspecialJugador: Veces que el jugador puede usar la habilidad especial (inicialmente 2).

usosHabilidadEspecialJefe: Veces que el jefe puede usar la habilidad especial (inicialmente 2).

Métodos
main:

Inicia el juego, permite la selección del personaje y comienza el combate.

Ciclo de combate hasta que uno de los personajes o el jefe sea derrotado.

dispararJugador:

Realiza un ataque estándar.

Aplica daño adicional si el jugador ha usado un bonus de daño.

usarBonusJugador:

Permite al jugador recuperar puntos de vida.

Reduce el contador de usos de bonus de curación.

usarBonusDañoJugador:

Añade daño adicional al siguiente ataque del jugador.

Reduce el contador de usos de bonus de daño.

usarHabilidadEspecialJugador:

Realiza un ataque especial que causa daño significativo al jefe.

Reduce el contador de usos de la habilidad especial.

turnoJefe:

Genera una acción aleatoria para el jefe (cubrirse, atacar, usar bonus o habilidad especial).

Aplica las consecuencias de la acción elegida.

mostrarEstadisticas:

Muestra las estadísticas actuales de vida del jefe y del personaje seleccionado.

Ciclo de Combate
Turno del Jugador:

El jugador elige una acción (disparar, usar bonus de curación, usar bonus de daño o usar habilidad especial).

Se ejecuta la acción elegida.

Se muestra el estado del juego después del turno.

Turno del Jefe:

Se genera una acción aleatoria para el jefe.

Se ejecuta la acción del jefe.

Se muestra el estado del juego después del turno.

Mostrar Estadísticas:

Se actualiza y muestra la vida restante del jefe y del personaje.

Fin del Juego:

Si el jefe es derrotado, se muestra un mensaje de victoria.

Si el héroe o villano es derrotado, se muestra un mensaje de derrota.
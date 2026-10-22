# Patrón Adapter – Reproductor multimedia

## Problema de incompatibilidad
- `AudioPlayer` implementa `MediaPlayer` (`play(String audioType, String fileName)`) y solo reproduce **mp3**.
- `VlcPlayer` y `Mp4Player` implementan `AdvancedMediaPlayer` (`playVlc(...)` y `playMp4(...)`).
- Las dos interfaces tienen métodos distintos, así que `AudioPlayer` no puede usar los reproductores avanzados directamente: son **interfaces incompatibles**.

## Solución
- **`MediaAdapter`** implementa `MediaPlayer` (la interfaz que espera el cliente) y guarda una referencia a un `AdvancedMediaPlayer` (el objeto adaptado).
  - En el constructor, según el `audioType`, crea un `VlcPlayer` o un `Mp4Player`.
  - En `play(...)` traduce la llamada: `vlc` → `playVlc(fileName)` y `mp4` → `playMp4(fileName)`.
- **`AudioPlayer`** conserva su comportamiento para mp3 y, para `vlc` y `mp4`, crea un `MediaAdapter` y le delega la reproducción. Para otros tipos imprime "Tipo de medio inválido".
- **`AdapterPatternDemo`** prueba mp3, mp4, vlc y un formato inválido (avi).

## Roles del patrón
| Rol | Clase |
|---|---|
| Cliente | `AudioPlayer` / `AdapterPatternDemo` |
| Interfaz objetivo (Target) | `MediaPlayer` |
| Adaptador (Adapter) | `MediaAdapter` |
| Interfaz adaptada (Adaptee) | `AdvancedMediaPlayer` |
| Adaptados concretos | `VlcPlayer`, `Mp4Player` |

## Resultado esperado
```
Reproduciendo archivo mp3: song.mp3
Reproduciendo archivo mp4: video.mp4
Reproduciendo archivo vlc: movie.vlc
Tipo de medio inválido: avi
```

## Ventajas
- Permite reutilizar clases existentes (`VlcPlayer`, `Mp4Player`) sin modificarlas.
- **Responsabilidad Única (SRP):** la conversión entre interfaces queda en `MediaAdapter`.
- **Abierto/Cerrado (OCP):** para soportar un formato nuevo se agrega un reproductor avanzado y se extiende el adaptador, sin tocar los reproductores existentes.
- El cliente trabaja siempre con la interfaz `MediaPlayer`.

## Nota
En la plantilla, `VlcPlayer.java` no tenía la línea `package Adapter;` mientras que las demás clases sí, lo que impide compilar. Se agregó esa línea.

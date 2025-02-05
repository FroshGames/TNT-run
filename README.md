# TNTRunPluguin

¡Un emocionante minijuego para Minecraft 1.20.1 donde la arena desaparece bajo tus pies y la TNT explota! Mantente en movimiento y evita caer en la trampa explosiva.

## 🚀 Características

- 🏃‍♂️ La arena desaparece al pisarla si hay TNT debajo.
- 💥 La TNT se activa tras un tiempo configurable.
- ⚙️ Comando `/tntrun <delay>` para cambiar el tiempo de activación de la TNT.
- 🔧 Configuración sencilla mediante `config.yml`.

## 📥 Instalación

1. Descarga el archivo **TNTRunPluguin.jar**.
2. Coloca el archivo en la carpeta `plugins/` de tu servidor Spigot/PaperMC 1.20.1.
3. Reinicia el servidor.
4. Ajusta la configuración en `config.yml` si es necesario.

## 🛠️ Comandos

| Comando         | Descripción                                    | Uso               |
|----------------|----------------------------------------------|------------------|
| `/tntrun <delay>` | Cambia el tiempo de activación de la TNT (en ticks). | `/tntrun 40` |

## ⚙️ Configuración (`config.yml`)

```yml
tnt-activation-delay: 20 # Tiempo en ticks antes de que la TNT explote


import com.jagrosh.discordipc.IPCClient
import com.jagrosh.discordipc.IPCListener
import com.jagrosh.discordipc.entities.RichPresence

import java.io.File
import java.time.OffsetDateTime

fun main() {
    // Look for a file in a ClientInfo directory containing a client
    // id for a discord OAuth2 application
    val clientId = File("ClientInfo/clientId.txt").readText().toLong()
    val client = IPCClient(clientId)
    client.setListener(
        object : IPCListener {
            override fun onReady(client: IPCClient) {
                val builder = RichPresence.Builder()
                builder
                    .setState("Alpha Quartermaster")
                    .setDetails("Frigate")
                    .setStartTimestamp(OffsetDateTime.now())
                    .setLargeImage("frigate", "frigate")
                    .setSmallImage("logo-small", "logo-small")
                client.sendRichPresence(builder.build())
            }
        }
    )
    client.connect()
}

package eu.kanade.tachiyomi.torrentutils

import eu.kanade.tachiyomi.torrentutils.model.Torrent

object TorrentUtils {

    suspend fun getTorrent(url: String, title: String): Torrent {
        throw Exception("Stub!")
    }

    suspend fun getTorrentPlayUrl(torrent: Torrent, indexFile: Int): String {
        throw Exception("Stub!")
    }

}
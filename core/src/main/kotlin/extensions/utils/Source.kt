package extensions.utils

import eu.kanade.tachiyomi.animesource.AnimeSource
import eu.kanade.tachiyomi.animesource.ConfigurableAnimeSource
import eu.kanade.tachiyomi.network.NetworkHelper
import okhttp3.OkHttpClient
import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get

abstract class Source : AnimeSource, ConfigurableAnimeSource {

    protected open val client: OkHttpClient
        get() = network.client

    private val network: NetworkHelper by lazy { Injekt.get<NetworkHelper>() }

    /**
     * @since extensions-lib 16
     */
    override fun setupPreferenceScreen(screen: androidx.preference.PreferenceScreen) {
        // Default implementation does nothing
    }
}
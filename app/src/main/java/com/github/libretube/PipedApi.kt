package com.github.libretube

import com.github.libretube.obj.*
import retrofit2.http.*

interface PipedApi {
    @GET("trending")
    suspend fun getTrending(@Query("region") region: String): List<StreamItem>

    @GET("streams/{videoId}")
    suspend fun getStreams(@Path("videoId") videoId: String): Streams

    @GET("comments/{videoId}")
    suspend fun getComments(@Path("videoId") videoId: String): CommentsPage

    @GET("nextpage/comments/{videoId}")
    suspend fun getCommentsNextPage(@Path("videoId") videoId: String, @Query("nextpage") nextPage: String): CommentsPage

    @GET("search")
    suspend fun getSearchResults(
        @Query("q") searchQuery: String,
        @Query("filter") filter: String
    ): SearchResult

    @GET("suggestions")
    suspend fun getSuggestions(@Query("query") query: String): List<String>

    @GET("channel/{channelId}")
    suspend fun getChannel(@Path("channelId") channelId: String): Channel

    @GET("nextpage/channel/{channelId}")
    suspend fun getChannelNextPage(@Path("channelId") channelId: String, @Query("nextpage") nextPage: String): Channel

    @GET("playlists/{playlistId}")
    suspend fun getPlaylist(@Path("playlistId") playlistId: String): Playlist

    @GET("nextpage/playlists/{playlistId}")
    suspend fun getPlaylistNextPage(@Path("playlistId") playlistId: String, @Query("nextpage") nextPage: String): Playlist

    @POST("login")
    suspend fun login(@Body login: Login): Token

    @POST("register")
    suspend fun register(@Body login: Login): Token

    @GET("feed")
    suspend fun getFeed(@Query("authToken") token: String?): List<StreamItem>

    @GET("subscribed")
    suspend fun isSubscribed(@Query("channelId") channelId: String, @Header("Authorization") token: String): Subscribed

    @GET("subscriptions")
    suspend fun subscriptions(@Header("Authorization") token: String): List<Subscription>

    @POST("subscribe")
    suspend fun subscribe(@Header("Authorization") token: String, @Body subscribe: Subscribe): Message

    @POST("unsubscribe")
    suspend fun unsubscribe(@Header("Authorization") token: String, @Body subscribe: Subscribe): Message

    @POST("import")
    suspend fun importSubscriptions(@Query("override") override: Boolean, @Header("Authorization") token: String, @Body channels: List<String>): Message

    @GET("user/playlists")
    suspend fun playlists(@Header("Authorization") token: String): List<Playlists>

    @POST("user/playlists/delete")
    suspend fun deletePlaylist(@Header("Authorization") token: String, @Body playlistId: PlaylistId): Message

    @POST("user/playlists/create")
    suspend fun createPlaylist(@Header("Authorization") token: String, @Body name: Playlists): PlaylistId

    @POST("user/playlists/add")
    suspend fun addToPlaylist(@Header("Authorization") token: String, @Body playlistId: PlaylistId): Message

    @POST("user/playlists/remove")
    suspend fun removeFromPlaylist(@Header("Authorization") token: String, @Body playlistId: PlaylistId): Message

    //only for fetching servers list
    @GET
    suspend fun getInstances(@Url url: String): List<Instances>



}
//
// NOTE: THIS FILE IS AUTO-GENERATED by the "TdApiKtxGenerator".kt
// See: https://github.com/tdlibx/td-ktx-generator/
//
package kotlinx.telegram.coroutines

import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.LongArray
import kotlin.String
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.CheckStickerSetNameResult
import org.drinkless.td.libcore.telegram.TdApi.InputFile
import org.drinkless.td.libcore.telegram.TdApi.InputSticker
import org.drinkless.td.libcore.telegram.TdApi.StickerSet
import org.drinkless.td.libcore.telegram.TdApi.StickerSets
import org.drinkless.td.libcore.telegram.TdApi.Stickers
import org.drinkless.td.libcore.telegram.TdApi.Text

/**
 * Suspend function, which adds a new sticker to the list of favorite stickers. The new sticker is
 * added to the top of the list. If the sticker was already in the list, it is removed from the list
 * first. Only stickers belonging to a sticker set can be added to this list.
 *
 * @param sticker Sticker file to add.
 */
suspend fun TelegramFlow.addFavoriteSticker(sticker: InputFile?) =
    this.sendFunctionLaunch(TdApi.AddFavoriteSticker(sticker))

/**
 * Suspend function, which manually adds a new sticker to the list of recently used stickers. The
 * new sticker is added to the top of the list. If the sticker was already in the list, it is removed
 * from the list first. Only stickers belonging to a sticker set can be added to this list.
 *
 * @param isAttached Pass true to add the sticker to the list of stickers recently attached to photo
 * or video files; pass false to add the sticker to the list of recently sent stickers.  
 * @param sticker Sticker file to add.
 *
 * @return [Stickers] Represents a list of stickers.
 */
suspend fun TelegramFlow.addRecentSticker(isAttached: Boolean, sticker: InputFile?): Stickers =
    this.sendFunctionAsync(TdApi.AddRecentSticker(isAttached, sticker))

/**
 * Suspend function, which adds a new sticker to a set; for bots only. Returns the sticker set.
 *
 * @param userId Sticker set owner.  
 * @param name Sticker set name.  
 * @param sticker Sticker to add to the set.
 *
 * @return [StickerSet] Represents a sticker set.
 */
suspend fun TelegramFlow.addStickerToSet(
  userId: Long,
  name: String?,
  sticker: InputSticker?
): StickerSet = this.sendFunctionAsync(TdApi.AddStickerToSet(userId, name, sticker))

/**
 * Suspend function, which installs/uninstalls or activates/archives a sticker set.
 *
 * @param setId Identifier of the sticker set.  
 * @param isInstalled The new value of isInstalled.  
 * @param isArchived The new value of isArchived. A sticker set can't be installed and archived
 * simultaneously.
 */
suspend fun TelegramFlow.changeStickerSet(
  setId: Long,
  isInstalled: Boolean,
  isArchived: Boolean
) = this.sendFunctionLaunch(TdApi.ChangeStickerSet(setId, isInstalled, isArchived))

/**
 * Suspend function, which checks whether a name can be used for a new sticker set.
 *
 * @param name Name to be checked.
 *
 * @return [CheckStickerSetNameResult] This class is an abstract base class.
 */
suspend fun TelegramFlow.checkStickerSetName(name: String?): CheckStickerSetNameResult =
    this.sendFunctionAsync(TdApi.CheckStickerSetName(name))

/**
 * Suspend function, which clears the list of recently used stickers.
 *
 * @param isAttached Pass true to clear the list of stickers recently attached to photo or video
 * files; pass false to clear the list of recently sent stickers.
 */
suspend fun TelegramFlow.clearRecentStickers(isAttached: Boolean) =
    this.sendFunctionLaunch(TdApi.ClearRecentStickers(isAttached))

/**
 * Suspend function, which creates a new sticker set. Returns the newly created sticker set.
 *
 * @param userId Sticker set owner; ignored for regular users.  
 * @param title Sticker set title; 1-64 characters.  
 * @param name Sticker set name. Can contain only English letters, digits and underscores. Must end
 * with *&quot;_by_&lt;bot username&gt;&quot;* (*&lt;botUsername&gt;* is case insensitive) for bots;
 * 1-64 characters.  
 * @param isMasks True, if stickers are masks. Animated stickers can't be masks.  
 * @param stickers List of stickers to be added to the set; must be non-empty. All stickers must be
 * of the same type. For animated stickers, uploadStickerFile must be used before the sticker is shown.
 *  
 * @param source Source of the sticker set; may be empty if unknown.
 *
 * @return [StickerSet] Represents a sticker set.
 */
suspend fun TelegramFlow.createNewStickerSet(
  userId: Long,
  title: String?,
  name: String?,
  isMasks: Boolean,
  stickers: Array<InputSticker>?,
  source: String?
): StickerSet = this.sendFunctionAsync(TdApi.CreateNewStickerSet(userId, title, name, isMasks,
    stickers, source))

/**
 * Suspend function, which returns a list of archived sticker sets.
 *
 * @param isMasks Pass true to return mask stickers sets; pass false to return ordinary sticker
 * sets.  
 * @param offsetStickerSetId Identifier of the sticker set from which to return the result.  
 * @param limit The maximum number of sticker sets to return; up to 100.
 *
 * @return [StickerSets] Represents a list of sticker sets.
 */
suspend fun TelegramFlow.getArchivedStickerSets(
  isMasks: Boolean,
  offsetStickerSetId: Long,
  limit: Int
): StickerSets = this.sendFunctionAsync(TdApi.GetArchivedStickerSets(isMasks, offsetStickerSetId,
    limit))

/**
 * Suspend function, which returns a list of sticker sets attached to a file. Currently only photos
 * and videos can have attached sticker sets.
 *
 * @param fileId File identifier.
 *
 * @return [StickerSets] Represents a list of sticker sets.
 */
suspend fun TelegramFlow.getAttachedStickerSets(fileId: Int): StickerSets =
    this.sendFunctionAsync(TdApi.GetAttachedStickerSets(fileId))

/**
 * Suspend function, which returns favorite stickers.
 *
 * @return [Stickers] Represents a list of stickers.
 */
suspend fun TelegramFlow.getFavoriteStickers(): Stickers =
    this.sendFunctionAsync(TdApi.GetFavoriteStickers())

/**
 * Suspend function, which returns a list of installed sticker sets.
 *
 * @param isMasks Pass true to return mask sticker sets; pass false to return ordinary sticker sets.
 *
 * @return [StickerSets] Represents a list of sticker sets.
 */
suspend fun TelegramFlow.getInstalledStickerSets(isMasks: Boolean): StickerSets =
    this.sendFunctionAsync(TdApi.GetInstalledStickerSets(isMasks))

/**
 * Suspend function, which returns a list of recently used stickers.
 *
 * @param isAttached Pass true to return stickers and masks that were recently attached to photos or
 * video files; pass false to return recently sent stickers.
 *
 * @return [Stickers] Represents a list of stickers.
 */
suspend fun TelegramFlow.getRecentStickers(isAttached: Boolean): Stickers =
    this.sendFunctionAsync(TdApi.GetRecentStickers(isAttached))

/**
 * Suspend function, which returns information about a sticker set by its identifier.
 *
 * @param setId Identifier of the sticker set.
 *
 * @return [StickerSet] Represents a sticker set.
 */
suspend fun TelegramFlow.getStickerSet(setId: Long): StickerSet =
    this.sendFunctionAsync(TdApi.GetStickerSet(setId))

/**
 * Suspend function, which returns stickers from the installed sticker sets that correspond to a
 * given emoji. If the emoji is non-empty, favorite and recently used stickers may also be returned.
 *
 * @param emoji String representation of emoji. If empty, returns all known installed stickers.  
 * @param limit The maximum number of stickers to be returned.
 *
 * @return [Stickers] Represents a list of stickers.
 */
suspend fun TelegramFlow.getStickers(emoji: String?, limit: Int): Stickers =
    this.sendFunctionAsync(TdApi.GetStickers(emoji, limit))

/**
 * Suspend function, which returns a suggested name for a new sticker set with a given title.
 *
 * @param title Sticker set title; 1-64 characters.
 *
 * @return [Text] Contains some text.
 */
suspend fun TelegramFlow.getSuggestedStickerSetName(title: String?): Text =
    this.sendFunctionAsync(TdApi.GetSuggestedStickerSetName(title))

/**
 * Suspend function, which returns a list of trending sticker sets. For optimal performance, the
 * number of returned sticker sets is chosen by TDLib.
 *
 * @param offset The offset from which to return the sticker sets; must be non-negative.  
 * @param limit The maximum number of sticker sets to be returned; up to 100. For optimal
 * performance, the number of returned sticker sets is chosen by TDLib and can be smaller than the
 * specified limit, even if the end of the list has not been reached.
 *
 * @return [StickerSets] Represents a list of sticker sets.
 */
suspend fun TelegramFlow.getTrendingStickerSets(offset: Int, limit: Int): StickerSets =
    this.sendFunctionAsync(TdApi.GetTrendingStickerSets(offset, limit))

/**
 * Suspend function, which removes a sticker from the list of favorite stickers.
 *
 * @param sticker Sticker file to delete from the list.
 */
suspend fun TelegramFlow.removeFavoriteSticker(sticker: InputFile?) =
    this.sendFunctionLaunch(TdApi.RemoveFavoriteSticker(sticker))

/**
 * Suspend function, which removes a sticker from the list of recently used stickers.
 *
 * @param isAttached Pass true to remove the sticker from the list of stickers recently attached to
 * photo or video files; pass false to remove the sticker from the list of recently sent stickers.  
 * @param sticker Sticker file to delete.
 */
suspend fun TelegramFlow.removeRecentSticker(isAttached: Boolean, sticker: InputFile?) =
    this.sendFunctionLaunch(TdApi.RemoveRecentSticker(isAttached, sticker))

/**
 * Suspend function, which removes a sticker from the set to which it belongs; for bots only. The
 * sticker set must have been created by the bot.
 *
 * @param sticker Sticker.
 */
suspend fun TelegramFlow.removeStickerFromSet(sticker: InputFile?) =
    this.sendFunctionLaunch(TdApi.RemoveStickerFromSet(sticker))

/**
 * Suspend function, which changes the order of installed sticker sets.
 *
 * @param isMasks Pass true to change the order of mask sticker sets; pass false to change the order
 * of ordinary sticker sets.  
 * @param stickerSetIds Identifiers of installed sticker sets in the new correct order.
 */
suspend fun TelegramFlow.reorderInstalledStickerSets(isMasks: Boolean, stickerSetIds: LongArray?) =
    this.sendFunctionLaunch(TdApi.ReorderInstalledStickerSets(isMasks, stickerSetIds))

/**
 * Suspend function, which searches for installed sticker sets by looking for specified query in
 * their title and name.
 *
 * @param isMasks Pass true to return mask sticker sets; pass false to return ordinary sticker sets.
 *  
 * @param query Query to search for.  
 * @param limit The maximum number of sticker sets to return.
 *
 * @return [StickerSets] Represents a list of sticker sets.
 */
suspend fun TelegramFlow.searchInstalledStickerSets(
  isMasks: Boolean,
  query: String?,
  limit: Int
): StickerSets = this.sendFunctionAsync(TdApi.SearchInstalledStickerSets(isMasks, query, limit))

/**
 * Suspend function, which searches for a sticker set by its name.
 *
 * @param name Name of the sticker set.
 *
 * @return [StickerSet] Represents a sticker set.
 */
suspend fun TelegramFlow.searchStickerSet(name: String?): StickerSet =
    this.sendFunctionAsync(TdApi.SearchStickerSet(name))

/**
 * Suspend function, which searches for ordinary sticker sets by looking for specified query in
 * their title and name. Excludes installed sticker sets from the results.
 *
 * @param query Query to search for.
 *
 * @return [StickerSets] Represents a list of sticker sets.
 */
suspend fun TelegramFlow.searchStickerSets(query: String?): StickerSets =
    this.sendFunctionAsync(TdApi.SearchStickerSets(query))

/**
 * Suspend function, which searches for stickers from public sticker sets that correspond to a given
 * emoji.
 *
 * @param emoji String representation of emoji; must be non-empty.  
 * @param limit The maximum number of stickers to be returned.
 *
 * @return [Stickers] Represents a list of stickers.
 */
suspend fun TelegramFlow.searchStickers(emoji: String?, limit: Int): Stickers =
    this.sendFunctionAsync(TdApi.SearchStickers(emoji, limit))

/**
 * Suspend function, which changes the position of a sticker in the set to which it belongs; for
 * bots only. The sticker set must have been created by the bot.
 *
 * @param sticker Sticker.  
 * @param position New position of the sticker in the set, zero-based.
 */
suspend fun TelegramFlow.setStickerPositionInSet(sticker: InputFile?, position: Int) =
    this.sendFunctionLaunch(TdApi.SetStickerPositionInSet(sticker, position))

/**
 * Suspend function, which sets a sticker set thumbnail; for bots only. Returns the sticker set.
 *
 * @param userId Sticker set owner.  
 * @param name Sticker set name.  
 * @param thumbnail Thumbnail to set in PNG or TGS format; pass null to remove the sticker set
 * thumbnail. Animated thumbnail must be set for animated sticker sets and only for them.
 *
 * @return [StickerSet] Represents a sticker set.
 */
suspend fun TelegramFlow.setStickerSetThumbnail(
  userId: Long,
  name: String?,
  thumbnail: InputFile?
): StickerSet = this.sendFunctionAsync(TdApi.SetStickerSetThumbnail(userId, name, thumbnail))

/**
 * Suspend function, which changes the sticker set of a supergroup; requires canChangeInfo
 * administrator right.
 *
 * @param supergroupId Identifier of the supergroup.  
 * @param stickerSetId New value of the supergroup sticker set identifier. Use 0 to remove the
 * supergroup sticker set.
 */
suspend fun TelegramFlow.setSupergroupStickerSet(supergroupId: Long, stickerSetId: Long) =
    this.sendFunctionLaunch(TdApi.SetSupergroupStickerSet(supergroupId, stickerSetId))

/**
 * Suspend function, which informs the server that some trending sticker sets have been viewed by
 * the user.
 *
 * @param stickerSetIds Identifiers of viewed trending sticker sets.
 */
suspend fun TelegramFlow.viewTrendingStickerSets(stickerSetIds: LongArray?) =
    this.sendFunctionLaunch(TdApi.ViewTrendingStickerSets(stickerSetIds))

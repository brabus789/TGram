//
// NOTE: THIS FILE IS AUTO-GENERATED by the "ExtensionsGenerator".kt
// See: https://github.com/tdlibx/td-ktx-generator/
//
package kotlinx.telegram.extensions

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.LongArray
import kotlin.String
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.coroutines.createSupergroupChat
import kotlinx.telegram.coroutines.getSupergroup
import kotlinx.telegram.coroutines.getSupergroupFullInfo
import kotlinx.telegram.coroutines.getSupergroupMembers
import kotlinx.telegram.coroutines.reportSupergroupSpam
import kotlinx.telegram.coroutines.setSupergroupStickerSet
import kotlinx.telegram.coroutines.setSupergroupUsername
import kotlinx.telegram.coroutines.toggleSupergroupIsAllHistoryAvailable
import kotlinx.telegram.coroutines.toggleSupergroupIsBroadcastGroup
import kotlinx.telegram.coroutines.toggleSupergroupSignMessages
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.Supergroup
import org.drinkless.td.libcore.telegram.TdApi.SupergroupMembersFilter

/**
 * Interface for access [TdApi.Supergroup] extension functions. Can be used alongside with other
 * extension interfaces of the package. Must contain [TelegramFlow] instance field to access its
 * functionality
 */
interface SupergroupKtx : BaseKtx {
  /**
   * Instance of the [TelegramFlow] connecting extensions to the Telegram Client
   */
  override val api: TelegramFlow

  /**
   * Suspend function, which returns an existing chat corresponding to a known supergroup or
   * channel.
   *
   * @param force If true, the chat will be created without network request. In this case all
   * information about the chat except its type, title and photo can be incorrect.
   *
   * @return [TdApi.Chat] A chat. (Can be a private chat, basic group, supergroup, or secret chat.)
   */
  suspend fun Supergroup.createChat(force: Boolean) = api.createSupergroupChat(this.id, force)

  /**
   * Suspend function, which returns information about a supergroup or a channel by its identifier.
   * This is an offline request if the current user is not a bot.
   *
   *
   * @return [TdApi.Supergroup] Represents a supergroup or channel with zero or more members
   * (subscribers in the case of channels). From the point of view of the system, a channel is a
   * special kind of a supergroup: only administrators can post and see the list of members, and posts
   * from all administrators use the name and photo of the channel instead of individual names and
   * profile photos. Unlike supergroups, channels can have an unlimited number of subscribers.
   */
  suspend fun Supergroup.get() = api.getSupergroup(this.id)

  /**
   * Suspend function, which returns full information about a supergroup or a channel by its
   * identifier, cached for up to 1 minute.
   *
   *
   * @return [TdApi.SupergroupFullInfo] Contains full information about a supergroup or channel.
   */
  suspend fun Supergroup.getFullInfo() = api.getSupergroupFullInfo(this.id)

  /**
   * Suspend function, which returns information about members or banned users in a supergroup or
   * channel. Can be used only if supergroupFullInfo.canGetMembers == true; additionally, administrator
   * privileges may be required for some filters.
   *
   * @param filter The type of users to return; pass null to use supergroupMembersFilterRecent.  
   * @param offset Number of users to skip.  
   * @param limit The maximum number of users be returned; up to 200.
   *
   * @return [TdApi.ChatMembers] Contains a list of chat members.
   */
  suspend fun Supergroup.getMembers(
    filter: SupergroupMembersFilter?,
    offset: Int,
    limit: Int
  ) = api.getSupergroupMembers(this.id, filter, offset, limit)

  /**
   * Suspend function, which reports some messages from a user in a supergroup as spam; requires
   * administrator rights in the supergroup.
   *
   * @param userId User identifier.  
   * @param messageIds Identifiers of messages sent in the supergroup by the user. This list must be
   * non-empty.
   */
  suspend fun Supergroup.reportSpam(userId: Long, messageIds: LongArray?) =
      api.reportSupergroupSpam(this.id, userId, messageIds)

  /**
   * Suspend function, which changes the sticker set of a supergroup; requires canChangeInfo
   * administrator right.
   *
   * @param stickerSetId New value of the supergroup sticker set identifier. Use 0 to remove the
   * supergroup sticker set.
   */
  suspend fun Supergroup.setStickerSet(stickerSetId: Long) = api.setSupergroupStickerSet(this.id,
      stickerSetId)

  /**
   * Suspend function, which changes the username of a supergroup or channel, requires owner
   * privileges in the supergroup or channel.
   *
   * @param username New value of the username. Use an empty string to remove the username.
   */
  suspend fun Supergroup.setUsername(username: String?) = api.setSupergroupUsername(this.id,
      username)

  /**
   * Suspend function, which toggles whether the message history of a supergroup is available to new
   * members; requires canChangeInfo administrator right.
   *
   * @param isAllHistoryAvailable The new value of isAllHistoryAvailable.
   */
  suspend fun Supergroup.toggleIsAllHistoryAvailable(isAllHistoryAvailable: Boolean) =
      api.toggleSupergroupIsAllHistoryAvailable(this.id, isAllHistoryAvailable)

  /**
   * Suspend function, which upgrades supergroup to a broadcast group; requires owner privileges in
   * the supergroup.
   */
  suspend fun Supergroup.toggleIsBroadcastGroup() = api.toggleSupergroupIsBroadcastGroup(this.id)

  /**
   * Suspend function, which toggles sender signatures messages sent in a channel; requires
   * canChangeInfo administrator right.
   *
   * @param signMessages New value of signMessages.
   */
  suspend fun Supergroup.toggleSignMessages(signMessages: Boolean) =
      api.toggleSupergroupSignMessages(this.id, signMessages)
}

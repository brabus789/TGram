//
// NOTE: THIS FILE IS AUTO-GENERATED by the "TdApiKtxGenerator".kt
// See: https://github.com/tdlibx/td-ktx-generator/
//
package kotlinx.telegram.coroutines

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.LongArray
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.ChatMembers
import org.drinkless.td.libcore.telegram.TdApi.Supergroup
import org.drinkless.td.libcore.telegram.TdApi.SupergroupFullInfo
import org.drinkless.td.libcore.telegram.TdApi.SupergroupMembersFilter

/**
 * Suspend function, which returns information about a supergroup or a channel by its identifier.
 * This is an offline request if the current user is not a bot.
 *
 * @param supergroupId Supergroup or channel identifier.
 *
 * @return [Supergroup] Represents a supergroup or channel with zero or more members (subscribers in
 * the case of channels). From the point of view of the system, a channel is a special kind of a
 * supergroup: only administrators can post and see the list of members, and posts from all
 * administrators use the name and photo of the channel instead of individual names and profile photos.
 * Unlike supergroups, channels can have an unlimited number of subscribers.
 */
suspend fun TelegramFlow.getSupergroup(supergroupId: Long): Supergroup =
    this.sendFunctionAsync(TdApi.GetSupergroup(supergroupId))

/**
 * Suspend function, which returns full information about a supergroup or a channel by its
 * identifier, cached for up to 1 minute.
 *
 * @param supergroupId Supergroup or channel identifier.
 *
 * @return [SupergroupFullInfo] Contains full information about a supergroup or channel.
 */
suspend fun TelegramFlow.getSupergroupFullInfo(supergroupId: Long): SupergroupFullInfo =
    this.sendFunctionAsync(TdApi.GetSupergroupFullInfo(supergroupId))

/**
 * Suspend function, which returns information about members or banned users in a supergroup or
 * channel. Can be used only if supergroupFullInfo.canGetMembers == true; additionally, administrator
 * privileges may be required for some filters.
 *
 * @param supergroupId Identifier of the supergroup or channel.  
 * @param filter The type of users to return; pass null to use supergroupMembersFilterRecent.  
 * @param offset Number of users to skip.  
 * @param limit The maximum number of users be returned; up to 200.
 *
 * @return [ChatMembers] Contains a list of chat members.
 */
suspend fun TelegramFlow.getSupergroupMembers(
  supergroupId: Long,
  filter: SupergroupMembersFilter?,
  offset: Int,
  limit: Int
): ChatMembers = this.sendFunctionAsync(TdApi.GetSupergroupMembers(supergroupId, filter, offset,
    limit))

/**
 * Suspend function, which reports some messages from a user in a supergroup as spam; requires
 * administrator rights in the supergroup.
 *
 * @param supergroupId Supergroup identifier.  
 * @param userId User identifier.  
 * @param messageIds Identifiers of messages sent in the supergroup by the user. This list must be
 * non-empty.
 */
suspend fun TelegramFlow.reportSupergroupSpam(
  supergroupId: Long,
  userId: Long,
  messageIds: LongArray?
) = this.sendFunctionLaunch(TdApi.ReportSupergroupSpam(supergroupId, userId, messageIds))

/**
 * Suspend function, which toggles whether the message history of a supergroup is available to new
 * members; requires canChangeInfo administrator right.
 *
 * @param supergroupId The identifier of the supergroup.  
 * @param isAllHistoryAvailable The new value of isAllHistoryAvailable.
 */
suspend fun TelegramFlow.toggleSupergroupIsAllHistoryAvailable(supergroupId: Long,
    isAllHistoryAvailable: Boolean) =
    this.sendFunctionLaunch(TdApi.ToggleSupergroupIsAllHistoryAvailable(supergroupId,
    isAllHistoryAvailable))

/**
 * Suspend function, which upgrades supergroup to a broadcast group; requires owner privileges in
 * the supergroup.
 *
 * @param supergroupId Identifier of the supergroup.
 */
suspend fun TelegramFlow.toggleSupergroupIsBroadcastGroup(supergroupId: Long) =
    this.sendFunctionLaunch(TdApi.ToggleSupergroupIsBroadcastGroup(supergroupId))
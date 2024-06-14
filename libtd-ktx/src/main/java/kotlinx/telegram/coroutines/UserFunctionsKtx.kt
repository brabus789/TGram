//
// NOTE: THIS FILE IS AUTO-GENERATED by the "TdApiKtxGenerator".kt
// See: https://github.com/tdlibx/td-ktx-generator/
//
package kotlinx.telegram.coroutines

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.ChatPhotos
import org.drinkless.td.libcore.telegram.TdApi.User
import org.drinkless.td.libcore.telegram.TdApi.UserFullInfo
import org.drinkless.td.libcore.telegram.TdApi.UserPrivacySetting
import org.drinkless.td.libcore.telegram.TdApi.UserPrivacySettingRules

/**
 * Suspend function, which returns a user that can be contacted to get support.
 *
 * @return [User] Represents a user.
 */
suspend fun TelegramFlow.getSupportUser(): User = this.sendFunctionAsync(TdApi.GetSupportUser())

/**
 * Suspend function, which returns information about a user by their identifier. This is an offline
 * request if the current user is not a bot.
 *
 * @param userId User identifier.
 *
 * @return [User] Represents a user.
 */
suspend fun TelegramFlow.getUser(userId: Long): User = this.sendFunctionAsync(TdApi.GetUser(userId))

/**
 * Suspend function, which returns full information about a user by their identifier.
 *
 * @param userId User identifier.
 *
 * @return [UserFullInfo] Contains full information about a user.
 */
suspend fun TelegramFlow.getUserFullInfo(userId: Long): UserFullInfo =
    this.sendFunctionAsync(TdApi.GetUserFullInfo(userId))

/**
 * Suspend function, which returns the current privacy settings.
 *
 * @param setting The privacy setting.
 *
 * @return [UserPrivacySettingRules] A list of privacy rules. Rules are matched in the specified
 * order. The first matched rule defines the privacy setting for a given user. If no rule matches, the
 * action is not allowed.
 */
suspend fun TelegramFlow.getUserPrivacySettingRules(setting: UserPrivacySetting?):
    UserPrivacySettingRules = this.sendFunctionAsync(TdApi.GetUserPrivacySettingRules(setting))

/**
 * Suspend function, which returns the profile photos of a user. The result of this query may be
 * outdated: some photos might have been deleted already.
 *
 * @param userId User identifier.  
 * @param offset The number of photos to skip; must be non-negative.  
 * @param limit The maximum number of photos to be returned; up to 100.
 *
 * @return [ChatPhotos] Contains a list of chat or user profile photos.
 */
suspend fun TelegramFlow.getUserProfilePhotos(
  userId: Long,
  offset: Int,
  limit: Int
): ChatPhotos = this.sendFunctionAsync(TdApi.GetUserProfilePhotos(userId, offset, limit))

/**
 * Suspend function, which finishes user registration. Works only when the current authorization
 * state is authorizationStateWaitRegistration.
 *
 * @param firstName The first name of the user; 1-64 characters.  
 * @param lastName The last name of the user; 0-64 characters.
 */
suspend fun TelegramFlow.registerUser(firstName: String?, lastName: String?) =
    this.sendFunctionLaunch(TdApi.RegisterUser(firstName, lastName))

/**
 * Suspend function, which changes the username of a supergroup or channel, requires owner
 * privileges in the supergroup or channel.
 *
 * @param supergroupId Identifier of the supergroup or channel.  
 * @param username New value of the username. Use an empty string to remove the username.
 */
suspend fun TelegramFlow.setSupergroupUsername(supergroupId: Long, username: String?) =
    this.sendFunctionLaunch(TdApi.SetSupergroupUsername(supergroupId, username))

/**
 * Suspend function, which changes user privacy settings.
 *
 * @param setting The privacy setting.  
 * @param rules The new privacy rules.
 */
suspend fun TelegramFlow.setUserPrivacySettingRules(setting: UserPrivacySetting?,
    rules: UserPrivacySettingRules?) =
    this.sendFunctionLaunch(TdApi.SetUserPrivacySettingRules(setting, rules))

/**
 * Suspend function, which changes the username of the current user.
 *
 * @param username The new value of the username. Use an empty string to remove the username.
 */
suspend fun TelegramFlow.setUsername(username: String?) =
    this.sendFunctionLaunch(TdApi.SetUsername(username))
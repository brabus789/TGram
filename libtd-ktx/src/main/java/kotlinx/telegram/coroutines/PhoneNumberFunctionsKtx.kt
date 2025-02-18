//
// NOTE: THIS FILE IS AUTO-GENERATED by the "TdApiKtxGenerator".kt
// See: https://github.com/tdlibx/td-ktx-generator/
//
package kotlinx.telegram.coroutines

import kotlin.Long
import kotlin.String
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.AuthenticationCodeInfo
import org.drinkless.td.libcore.telegram.TdApi.PhoneNumberAuthenticationSettings
import org.drinkless.td.libcore.telegram.TdApi.PhoneNumberInfo

/**
 * Suspend function, which changes the phone number of the user and sends an authentication code to
 * the user's new phone number. On success, returns information about the sent code.
 *
 * @param phoneNumber The new phone number of the user in international format.  
 * @param settings Settings for the authentication of the user's phone number; pass null to use
 * default settings.
 *
 * @return [AuthenticationCodeInfo] Information about the authentication code that was sent.
 */
suspend fun TelegramFlow.changePhoneNumber(phoneNumber: String?,
    settings: PhoneNumberAuthenticationSettings?): AuthenticationCodeInfo =
    this.sendFunctionAsync(TdApi.ChangePhoneNumber(phoneNumber, settings))

/**
 * Suspend function, which checks the authentication code sent to confirm a new phone number of the
 * user.
 *
 * @param code Verification code received by SMS, phone call or flash call.
 */
suspend fun TelegramFlow.checkChangePhoneNumberCode(code: String?) =
    this.sendFunctionLaunch(TdApi.CheckChangePhoneNumberCode(code))

/**
 * Suspend function, which checks phone number confirmation code.
 *
 * @param code The phone number confirmation code.
 */
suspend fun TelegramFlow.checkPhoneNumberConfirmationCode(code: String?) =
    this.sendFunctionLaunch(TdApi.CheckPhoneNumberConfirmationCode(code))

/**
 * Suspend function, which checks the phone number verification code for Telegram Passport.
 *
 * @param code Verification code.
 */
suspend fun TelegramFlow.checkPhoneNumberVerificationCode(code: String?) =
    this.sendFunctionLaunch(TdApi.CheckPhoneNumberVerificationCode(code))

/**
 * Suspend function, which returns information about a phone number by its prefix. Can be called
 * before authorization.
 *
 * @param phoneNumberPrefix The phone number prefix.
 *
 * @return [PhoneNumberInfo] Contains information about a phone number.
 */
suspend fun TelegramFlow.getPhoneNumberInfo(phoneNumberPrefix: String?): PhoneNumberInfo =
    this.sendFunctionAsync(TdApi.GetPhoneNumberInfo(phoneNumberPrefix))

/**
 * Suspend function, which returns information about a phone number by its prefix synchronously.
 * getCountries must be called at least once after changing localization to the specified language if
 * properly localized country information is expected. Can be called synchronously.
 *
 * @param languageCode A two-letter ISO 639-1 country code for country information localization.  
 * @param phoneNumberPrefix The phone number prefix.
 *
 * @return [PhoneNumberInfo] Contains information about a phone number.
 */
suspend fun TelegramFlow.getPhoneNumberInfoSync(languageCode: String?, phoneNumberPrefix: String?):
    PhoneNumberInfo = this.sendFunctionAsync(TdApi.GetPhoneNumberInfoSync(languageCode,
    phoneNumberPrefix))

/**
 * Suspend function, which re-sends the authentication code sent to confirm a new phone number for
 * the current user. Works only if the previously received authenticationCodeInfo nextCodeType was not
 * null and the server-specified timeout has passed.
 *
 * @return [AuthenticationCodeInfo] Information about the authentication code that was sent.
 */
suspend fun TelegramFlow.resendChangePhoneNumberCode(): AuthenticationCodeInfo =
    this.sendFunctionAsync(TdApi.ResendChangePhoneNumberCode())

/**
 * Suspend function, which resends phone number confirmation code.
 *
 * @return [AuthenticationCodeInfo] Information about the authentication code that was sent.
 */
suspend fun TelegramFlow.resendPhoneNumberConfirmationCode(): AuthenticationCodeInfo =
    this.sendFunctionAsync(TdApi.ResendPhoneNumberConfirmationCode())

/**
 * Suspend function, which re-sends the code to verify a phone number to be added to a user's
 * Telegram Passport.
 *
 * @return [AuthenticationCodeInfo] Information about the authentication code that was sent.
 */
suspend fun TelegramFlow.resendPhoneNumberVerificationCode(): AuthenticationCodeInfo =
    this.sendFunctionAsync(TdApi.ResendPhoneNumberVerificationCode())

/**
 * Suspend function, which sends phone number confirmation code to handle links of the type
 * internalLinkTypePhoneNumberConfirmation.
 *
 * @param hash Hash value from the link.  
 * @param phoneNumber Phone number value from the link.  
 * @param settings Settings for the authentication of the user's phone number; pass null to use
 * default settings.
 *
 * @return [AuthenticationCodeInfo] Information about the authentication code that was sent.
 */
suspend fun TelegramFlow.sendPhoneNumberConfirmationCode(
  hash: String?,
  phoneNumber: String?,
  settings: PhoneNumberAuthenticationSettings?
): AuthenticationCodeInfo = this.sendFunctionAsync(TdApi.SendPhoneNumberConfirmationCode(hash,
    phoneNumber, settings))

/**
 * Suspend function, which sends a code to verify a phone number to be added to a user's Telegram
 * Passport.
 *
 * @param phoneNumber The phone number of the user, in international format.  
 * @param settings Settings for the authentication of the user's phone number; pass null to use
 * default settings.
 *
 * @return [AuthenticationCodeInfo] Information about the authentication code that was sent.
 */
suspend fun TelegramFlow.sendPhoneNumberVerificationCode(phoneNumber: String?,
    settings: PhoneNumberAuthenticationSettings?): AuthenticationCodeInfo =
    this.sendFunctionAsync(TdApi.SendPhoneNumberVerificationCode(phoneNumber, settings))

/**
 * Suspend function, which sets the phone number of the user and sends an authentication code to the
 * user. Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if
 * there is no pending authentication query and the current authorization state is
 * authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword.
 *
 * @param phoneNumber The phone number of the user, in international format.  
 * @param settings Settings for the authentication of the user's phone number; pass null to use
 * default settings.
 */
suspend fun TelegramFlow.setAuthenticationPhoneNumber(phoneNumber: String?,
    settings: PhoneNumberAuthenticationSettings?) =
    this.sendFunctionLaunch(TdApi.SetAuthenticationPhoneNumber(phoneNumber, settings))

/**
 * Suspend function, which shares the phone number of the current user with a mutual contact.
 * Supposed to be called when the user clicks on chatActionBarSharePhoneNumber.
 *
 * @param userId Identifier of the user with whom to share the phone number. The user must be a
 * mutual contact.
 */
suspend fun TelegramFlow.sharePhoneNumber(userId: Long) =
    this.sendFunctionLaunch(TdApi.SharePhoneNumber(userId))

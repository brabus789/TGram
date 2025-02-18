//
// NOTE: THIS FILE IS AUTO-GENERATED by the "ExtensionsGenerator".kt
// See: https://github.com/tdlibx/td-ktx-generator/
//
package kotlinx.telegram.extensions

import kotlin.Boolean
import kotlin.Int
import kotlin.IntArray
import kotlin.Long
import kotlin.String
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.coroutines.blockMessageSenderFromReplies
import kotlinx.telegram.coroutines.clickAnimatedEmojiMessage
import kotlinx.telegram.coroutines.deleteChatReplyMarkup
import kotlinx.telegram.coroutines.editMessageCaption
import kotlinx.telegram.coroutines.editMessageLiveLocation
import kotlinx.telegram.coroutines.editMessageMedia
import kotlinx.telegram.coroutines.editMessageReplyMarkup
import kotlinx.telegram.coroutines.editMessageSchedulingState
import kotlinx.telegram.coroutines.editMessageText
import kotlinx.telegram.coroutines.getCallbackQueryAnswer
import kotlinx.telegram.coroutines.getCallbackQueryMessage
import kotlinx.telegram.coroutines.getGameHighScores
import kotlinx.telegram.coroutines.getLoginUrl
import kotlinx.telegram.coroutines.getLoginUrlInfo
import kotlinx.telegram.coroutines.getMessage
import kotlinx.telegram.coroutines.getMessageEmbeddingCode
import kotlinx.telegram.coroutines.getMessageLink
import kotlinx.telegram.coroutines.getMessageLocally
import kotlinx.telegram.coroutines.getMessagePublicForwards
import kotlinx.telegram.coroutines.getMessageStatistics
import kotlinx.telegram.coroutines.getMessageThread
import kotlinx.telegram.coroutines.getMessageThreadHistory
import kotlinx.telegram.coroutines.getMessageViewers
import kotlinx.telegram.coroutines.getPaymentForm
import kotlinx.telegram.coroutines.getPaymentReceipt
import kotlinx.telegram.coroutines.getPollVoters
import kotlinx.telegram.coroutines.getRepliedMessage
import kotlinx.telegram.coroutines.openMessageContent
import kotlinx.telegram.coroutines.pinChatMessage
import kotlinx.telegram.coroutines.sendPaymentForm
import kotlinx.telegram.coroutines.setGameScore
import kotlinx.telegram.coroutines.setPollAnswer
import kotlinx.telegram.coroutines.stopPoll
import kotlinx.telegram.coroutines.unpinChatMessage
import kotlinx.telegram.coroutines.validateOrderInfo
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.CallbackQueryPayload
import org.drinkless.td.libcore.telegram.TdApi.FormattedText
import org.drinkless.td.libcore.telegram.TdApi.InputCredentials
import org.drinkless.td.libcore.telegram.TdApi.InputMessageContent
import org.drinkless.td.libcore.telegram.TdApi.Location
import org.drinkless.td.libcore.telegram.TdApi.Message
import org.drinkless.td.libcore.telegram.TdApi.MessageSchedulingState
import org.drinkless.td.libcore.telegram.TdApi.OrderInfo
import org.drinkless.td.libcore.telegram.TdApi.PaymentFormTheme
import org.drinkless.td.libcore.telegram.TdApi.ReplyMarkup

/**
 * Interface for access [TdApi.Message] extension functions. Can be used alongside with other
 * extension interfaces of the package. Must contain [TelegramFlow] instance field to access its
 * functionality
 */
interface MessageKtx : BaseKtx {
  /**
   * Instance of the [TelegramFlow] connecting extensions to the Telegram Client
   */
  override val api: TelegramFlow

  /**
   * Suspend function, which blocks an original sender of a message in the Replies chat.
   *
   * @param deleteMessage Pass true if the message must be deleted.  
   * @param deleteAllMessages Pass true if all messages from the same sender must be deleted.  
   * @param reportSpam Pass true if the sender must be reported to the Telegram moderators.
   */
  suspend fun Message.blockSenderFromReplies(
    deleteMessage: Boolean,
    deleteAllMessages: Boolean,
    reportSpam: Boolean
  ) = api.blockMessageSenderFromReplies(this.id, deleteMessage, deleteAllMessages, reportSpam)

  /**
   * Suspend function, which informs TDLib that a message with an animated emoji was clicked by the
   * user. Returns a big animated sticker to be played or a 404 error if usual animation needs to be
   * played.
   *
   * @param chatId Chat identifier of the message.  
   *
   * @return [TdApi.Sticker] Describes a sticker.
   */
  suspend fun Message.clickAnimatedEmoji(chatId: Long) = api.clickAnimatedEmojiMessage(chatId,
      this.id)

  /**
   * Suspend function, which deletes the default reply markup from a chat. Must be called after a
   * one-time keyboard or a ForceReply reply markup has been used. UpdateChatReplyMarkup will be sent
   * if the reply markup is changed.
   *
   * @param chatId Chat identifier.  
   */
  suspend fun Message.deleteChatReplyMarkup(chatId: Long) = api.deleteChatReplyMarkup(chatId,
      this.id)

  /**
   * Suspend function, which edits the message content caption. Returns the edited message after the
   * edit is completed on the server side.
   *
   * @param chatId The chat the message belongs to.  
   * @param replyMarkup The new message reply markup; pass null if none; for bots only.  
   * @param caption New message content caption; 0-GetOption(&quot;message_caption_length_max&quot;)
   * characters; pass null to remove caption.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.editCaption(
    chatId: Long,
    replyMarkup: ReplyMarkup?,
    caption: FormattedText?
  ) = api.editMessageCaption(chatId, this.id, replyMarkup, caption)

  /**
   * Suspend function, which edits the message content of a live location. Messages can be edited
   * for a limited period of time specified in the live location. Returns the edited message after the
   * edit is completed on the server side.
   *
   * @param chatId The chat the message belongs to.  
   * @param replyMarkup The new message reply markup; pass null if none; for bots only.  
   * @param location New location content of the message; pass null to stop sharing the live
   * location.  
   * @param heading The new direction in which the location moves, in degrees; 1-360. Pass 0 if
   * unknown.  
   * @param proximityAlertRadius The new maximum distance for proximity alerts, in meters
   * (0-100000). Pass 0 if the notification is disabled.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.editLiveLocation(
    chatId: Long,
    replyMarkup: ReplyMarkup?,
    location: Location?,
    heading: Int,
    proximityAlertRadius: Int
  ) = api.editMessageLiveLocation(chatId, this.id, replyMarkup, location, heading,
      proximityAlertRadius)

  /**
   * Suspend function, which edits the content of a message with an animation, an audio, a document,
   * a photo or a video, including message caption. If only the caption needs to be edited, use
   * editMessageCaption instead. The media can't be edited if the message was set to self-destruct or
   * to a self-destructing media. The type of message content in an album can't be changed with
   * exception of replacing a photo with a video or vice versa. Returns the edited message after the
   * edit is completed on the server side.
   *
   * @param chatId The chat the message belongs to.  
   * @param replyMarkup The new message reply markup; pass null if none; for bots only.  
   * @param inputMessageContent New content of the message. Must be one of the following types:
   * inputMessageAnimation, inputMessageAudio, inputMessageDocument, inputMessagePhoto or
   * inputMessageVideo.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.editMedia(
    chatId: Long,
    replyMarkup: ReplyMarkup?,
    inputMessageContent: InputMessageContent?
  ) = api.editMessageMedia(chatId, this.id, replyMarkup, inputMessageContent)

  /**
   * Suspend function, which edits the message reply markup; for bots only. Returns the edited
   * message after the edit is completed on the server side.
   *
   * @param chatId The chat the message belongs to.  
   * @param replyMarkup The new message reply markup; pass null if none.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.editReplyMarkup(chatId: Long, replyMarkup: ReplyMarkup?) =
      api.editMessageReplyMarkup(chatId, this.id, replyMarkup)

  /**
   * Suspend function, which edits the time when a scheduled message will be sent. Scheduling state
   * of all messages in the same album or forwarded together with the message will be also changed.
   *
   * @param chatId The chat the message belongs to.  
   * @param schedulingState The new message scheduling state; pass null to send the message
   * immediately.
   */
  suspend fun Message.editSchedulingState(chatId: Long, schedulingState: MessageSchedulingState?) =
      api.editMessageSchedulingState(chatId, this.id, schedulingState)

  /**
   * Suspend function, which edits the text of a message (or a text of a game message). Returns the
   * edited message after the edit is completed on the server side.
   *
   * @param chatId The chat the message belongs to.  
   * @param replyMarkup The new message reply markup; pass null if none; for bots only.  
   * @param inputMessageContent New text content of the message. Must be of type inputMessageText.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.editText(
    chatId: Long,
    replyMarkup: ReplyMarkup?,
    inputMessageContent: InputMessageContent?
  ) = api.editMessageText(chatId, this.id, replyMarkup, inputMessageContent)

  /**
   * Suspend function, which sends a callback query to a bot and returns an answer. Returns an error
   * with code 502 if the bot fails to answer the query before the query timeout expires.
   *
   * @param chatId Identifier of the chat with the message.  
   * @param payload Query payload.
   *
   * @return [TdApi.CallbackQueryAnswer] Contains a bot's answer to a callback query.
   */
  suspend fun Message.getCallbackQueryAnswer(chatId: Long, payload: CallbackQueryPayload?) =
      api.getCallbackQueryAnswer(chatId, this.id, payload)

  /**
   * Suspend function, which returns information about a message with the callback button that
   * originated a callback query; for bots only.
   *
   * @param chatId Identifier of the chat the message belongs to.  
   * @param callbackQueryId Identifier of the callback query.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.getCallbackQuery(chatId: Long, callbackQueryId: Long) =
      api.getCallbackQueryMessage(chatId, this.id, callbackQueryId)

  /**
   * Suspend function, which returns the high scores for a game and some part of the high score
   * table in the range of the specified user; for bots only.
   *
   * @param chatId The chat that contains the message with the game.  
   * @param userId User identifier.
   *
   * @return [TdApi.GameHighScores] Contains a list of game high scores.
   */
  suspend fun Message.getGameHighScores(chatId: Long, userId: Long) = api.getGameHighScores(chatId,
      this.id, userId)

  /**
   * Suspend function, which returns an HTTP URL which can be used to automatically authorize the
   * user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl. Use
   * the method getLoginUrlInfo to find whether a prior user confirmation is needed. If an error is
   * returned, then the button must be handled as an ordinary URL button.
   *
   * @param chatId Chat identifier of the message with the button.  
   * @param buttonId Button identifier.  
   * @param allowWriteAccess True, if the user allowed the bot to send them messages.
   *
   * @return [TdApi.HttpUrl] Contains an HTTP URL.
   */
  suspend fun Message.getLoginUrl(
    chatId: Long,
    buttonId: Long,
    allowWriteAccess: Boolean
  ) = api.getLoginUrl(chatId, this.id, buttonId, allowWriteAccess)

  /**
   * Suspend function, which returns information about a button of type
   * inlineKeyboardButtonTypeLoginUrl. The method needs to be called when the user presses the button.
   *
   * @param chatId Chat identifier of the message with the button.  
   * @param buttonId Button identifier.
   *
   * @return [TdApi.LoginUrlInfo] This class is an abstract base class.
   */
  suspend fun Message.getLoginUrlInfo(chatId: Long, buttonId: Long) = api.getLoginUrlInfo(chatId,
      this.id, buttonId)

  /**
   * Suspend function, which returns information about a message.
   *
   * @param chatId Identifier of the chat the message belongs to.  
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.get(chatId: Long) = api.getMessage(chatId, this.id)

  /**
   * Suspend function, which returns an HTML code for embedding the message. Available only for
   * messages in supergroups and channels with a username.
   *
   * @param chatId Identifier of the chat to which the message belongs.  
   * @param forAlbum Pass true to return an HTML code for embedding of the whole media album.
   *
   * @return [TdApi.Text] Contains some text.
   */
  suspend fun Message.getEmbeddingCode(chatId: Long, forAlbum: Boolean) =
      api.getMessageEmbeddingCode(chatId, this.id, forAlbum)

  /**
   * Suspend function, which returns an HTTPS link to a message in a chat. Available only for
   * already sent messages in supergroups and channels, or if message.canGetMediaTimestampLinks and a
   * media timestamp link is generated. This is an offline request.
   *
   * @param chatId Identifier of the chat to which the message belongs.  
   * @param mediaTimestamp If not 0, timestamp from which the video/audio/video note/voice note
   * playing must start, in seconds. The media can be in the message content or in its web page
   * preview.  
   * @param forAlbum Pass true to create a link for the whole media album.  
   * @param forComment Pass true to create a link to the message as a channel post comment, or from
   * a message thread.
   *
   * @return [TdApi.MessageLink] Contains an HTTPS link to a message in a supergroup or channel.
   */
  suspend fun Message.getLink(
    chatId: Long,
    mediaTimestamp: Int,
    forAlbum: Boolean,
    forComment: Boolean
  ) = api.getMessageLink(chatId, this.id, mediaTimestamp, forAlbum, forComment)

  /**
   * Suspend function, which returns information about a message, if it is available locally without
   * sending network request. This is an offline request.
   *
   * @param chatId Identifier of the chat the message belongs to.  
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.getLocally(chatId: Long) = api.getMessageLocally(chatId, this.id)

  /**
   * Suspend function, which returns forwarded copies of a channel message to different public
   * channels. For optimal performance, the number of returned messages is chosen by TDLib.
   *
   * @param chatId Chat identifier of the message.  
   * @param offset Offset of the first entry to return as received from the previous request; use
   * empty string to get first chunk of results.  
   * @param limit The maximum number of messages to be returned; must be positive and can't be
   * greater than 100. For optimal performance, the number of returned messages is chosen by TDLib and
   * can be smaller than the specified limit.
   *
   * @return [TdApi.FoundMessages] Contains a list of messages found by a search.
   */
  suspend fun Message.getPublicForwards(
    chatId: Long,
    offset: String?,
    limit: Int
  ) = api.getMessagePublicForwards(chatId, this.id, offset, limit)

  /**
   * Suspend function, which returns detailed statistics about a message. Can be used only if
   * message.canGetStatistics == true.
   *
   * @param chatId Chat identifier.  
   * @param isDark Pass true if a dark theme is used by the application.
   *
   * @return [TdApi.MessageStatistics] A detailed statistics about a message.
   */
  suspend fun Message.getStatistics(chatId: Long, isDark: Boolean) =
      api.getMessageStatistics(chatId, this.id, isDark)

  /**
   * Suspend function, which returns information about a message thread. Can be used only if
   * message.canGetMessageThread == true.
   *
   * @param chatId Chat identifier.  
   *
   * @return [TdApi.MessageThreadInfo] Contains information about a message thread.
   */
  suspend fun Message.getThread(chatId: Long) = api.getMessageThread(chatId, this.id)

  /**
   * Suspend function, which returns messages in a message thread of a message. Can be used only if
   * message.canGetMessageThread == true. Message thread of a channel message is in the channel's
   * linked supergroup. The messages are returned in a reverse chronological order (i.e., in order of
   * decreasing messageId). For optimal performance, the number of returned messages is chosen by
   * TDLib.
   *
   * @param chatId Chat identifier.  
   * @param fromMessageId Identifier of the message starting from which history must be fetched; use
   * 0 to get results from the last message.  
   * @param offset Specify 0 to get results from exactly the fromMessageId or a negative offset up
   * to 99 to get additionally some newer messages.  
   * @param limit The maximum number of messages to be returned; must be positive and can't be
   * greater than 100. If the offset is negative, the limit must be greater than or equal to -offset.
   * For optimal performance, the number of returned messages is chosen by TDLib and can be smaller
   * than the specified limit.
   *
   * @return [TdApi.Messages] Contains a list of messages.
   */
  suspend fun Message.getThreadHistory(
    chatId: Long,
    fromMessageId: Long,
    offset: Int,
    limit: Int
  ) = api.getMessageThreadHistory(chatId, this.id, fromMessageId, offset, limit)

  /**
   * Suspend function, which returns viewers of a recent outgoing message in a basic group or a
   * supergroup chat. For video notes and voice notes only users, opened content of the message, are
   * returned. The method can be called if message.canGetViewers == true.
   *
   * @param chatId Chat identifier.  
   *
   * @return [TdApi.Users] Represents a list of users.
   */
  suspend fun Message.getViewers(chatId: Long) = api.getMessageViewers(chatId, this.id)

  /**
   * Suspend function, which returns an invoice payment form. This method must be called when the
   * user presses inlineKeyboardButtonBuy.
   *
   * @param chatId Chat identifier of the Invoice message.  
   * @param theme Preferred payment form theme; pass null to use the default theme.
   *
   * @return [TdApi.PaymentForm] Contains information about an invoice payment form.
   */
  suspend fun Message.getPaymentForm(chatId: Long, theme: PaymentFormTheme?) =
      api.getPaymentForm(chatId, this.id, theme)

  /**
   * Suspend function, which returns information about a successful payment.
   *
   * @param chatId Chat identifier of the PaymentSuccessful message.  
   *
   * @return [TdApi.PaymentReceipt] Contains information about a successful payment.
   */
  suspend fun Message.getPaymentReceipt(chatId: Long) = api.getPaymentReceipt(chatId, this.id)

  /**
   * Suspend function, which returns users voted for the specified option in a non-anonymous polls.
   * For optimal performance, the number of returned users is chosen by TDLib.
   *
   * @param chatId Identifier of the chat to which the poll belongs.  
   * @param optionId 0-based identifier of the answer option.  
   * @param offset Number of users to skip in the result; must be non-negative.  
   * @param limit The maximum number of users to be returned; must be positive and can't be greater
   * than 50. For optimal performance, the number of returned users is chosen by TDLib and can be
   * smaller than the specified limit, even if the end of the voter list has not been reached.
   *
   * @return [TdApi.Users] Represents a list of users.
   */
  suspend fun Message.getPollVoters(
    chatId: Long,
    optionId: Int,
    offset: Int,
    limit: Int
  ) = api.getPollVoters(chatId, this.id, optionId, offset, limit)

  /**
   * Suspend function, which returns information about a message that is replied by a given message.
   * Also returns the pinned message, the game message, and the invoice message for messages of the
   * types messagePinMessage, messageGameScore, and messagePaymentSuccessful respectively.
   *
   * @param chatId Identifier of the chat the message belongs to.  
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.getReplied(chatId: Long) = api.getRepliedMessage(chatId, this.id)

  /**
   * Suspend function, which informs TDLib that the message content has been opened (e.g., the user
   * has opened a photo, video, document, location or venue, or has listened to an audio file or voice
   * note message). An updateMessageContentOpened update will be generated if something has changed.
   *
   * @param chatId Chat identifier of the message.  
   */
  suspend fun Message.openContent(chatId: Long) = api.openMessageContent(chatId, this.id)

  /**
   * Suspend function, which pins a message in a chat; requires canPinMessages rights or
   * canEditMessages rights in the channel.
   *
   * @param chatId Identifier of the chat.  
   * @param disableNotification True, if there must be no notification about the pinned message.
   * Notifications are always disabled in channels and private chats.  
   * @param onlyForSelf True, if the message needs to be pinned for one side only; private chats
   * only.
   */
  suspend fun Message.pinChat(
    chatId: Long,
    disableNotification: Boolean,
    onlyForSelf: Boolean
  ) = api.pinChatMessage(chatId, this.id, disableNotification, onlyForSelf)

  /**
   * Suspend function, which sends a filled-out payment form to the bot for final verification.
   *
   * @param chatId Chat identifier of the Invoice message.  
   * @param paymentFormId Payment form identifier returned by getPaymentForm.  
   * @param orderInfoId Identifier returned by validateOrderInfo, or an empty string.  
   * @param shippingOptionId Identifier of a chosen shipping option, if applicable.  
   * @param credentials The credentials chosen by user for payment.  
   * @param tipAmount Chosen by the user amount of tip in the smallest units of the currency.
   *
   * @return [TdApi.PaymentResult] Contains the result of a payment request.
   */
  suspend fun Message.sendPaymentForm(
    chatId: Long,
    paymentFormId: Long,
    orderInfoId: String?,
    shippingOptionId: String?,
    credentials: InputCredentials?,
    tipAmount: Long
  ) = api.sendPaymentForm(chatId, this.id, paymentFormId, orderInfoId, shippingOptionId,
      credentials, tipAmount)

  /**
   * Suspend function, which updates the game score of the specified user in the game; for bots
   * only.
   *
   * @param chatId The chat to which the message with the game belongs.  
   * @param editMessage True, if the message needs to be edited.  
   * @param userId User identifier.  
   * @param score The new score.  
   * @param force Pass true to update the score even if it decreases. If the score is 0, the user
   * will be deleted from the high score table.
   *
   * @return [TdApi.Message] Describes a message.
   */
  suspend fun Message.setGameScore(
    chatId: Long,
    editMessage: Boolean,
    userId: Long,
    score: Int,
    force: Boolean
  ) = api.setGameScore(chatId, this.id, editMessage, userId, score, force)

  /**
   * Suspend function, which changes the user answer to a poll. A poll in quiz mode can be answered
   * only once.
   *
   * @param chatId Identifier of the chat to which the poll belongs.  
   * @param optionIds 0-based identifiers of answer options, chosen by the user. User can choose
   * more than 1 answer option only is the poll allows multiple answers.
   */
  suspend fun Message.setPollAnswer(chatId: Long, optionIds: IntArray?) = api.setPollAnswer(chatId,
      this.id, optionIds)

  /**
   * Suspend function, which stops a poll. A poll in a message can be stopped when the message has
   * canBeEdited flag set.
   *
   * @param chatId Identifier of the chat to which the poll belongs.  
   * @param replyMarkup The new message reply markup; pass null if none; for bots only.
   */
  suspend fun Message.stopPoll(chatId: Long, replyMarkup: ReplyMarkup?) = api.stopPoll(chatId,
      this.id, replyMarkup)

  /**
   * Suspend function, which removes a pinned message from a chat; requires canPinMessages rights in
   * the group or canEditMessages rights in the channel.
   *
   * @param chatId Identifier of the chat.  
   */
  suspend fun Message.unpinChat(chatId: Long) = api.unpinChatMessage(chatId, this.id)

  /**
   * Suspend function, which validates the order information provided by a user and returns the
   * available shipping options for a flexible invoice.
   *
   * @param chatId Chat identifier of the Invoice message.  
   * @param orderInfo The order information, provided by the user; pass null if empty.  
   * @param allowSave True, if the order information can be saved.
   *
   * @return [TdApi.ValidatedOrderInfo] Contains a temporary identifier of validated order
   * information, which is stored for one hour. Also contains the available shipping options.
   */
  suspend fun Message.validateOrderInfo(
    chatId: Long,
    orderInfo: OrderInfo?,
    allowSave: Boolean
  ) = api.validateOrderInfo(chatId, this.id, orderInfo, allowSave)
}

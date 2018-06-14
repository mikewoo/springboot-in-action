package com.mikewoo.study.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * 邮件发送服务
 *
 * @auther Phantom Gui
 * @date 2018/6/14 9:40
 */
public interface MailService {

    /**
     * 发送普通文本邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件正文
     * @param cc 抄送人列表
     */
    void sendSimpleMail(String[] to, String subject, String content, String... cc);

    /**
     * 发送富文本格式邮件(HTML格式)
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件正文
     * @param cc 抄送人列表
     */
    void sendHtmlMail(String[] to, String subject, String content, String... cc);

    /**
     * 发送带附件的富文本格式邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件正文
     * @param filePaths 附件本地资源目录
     * @param cc 抄送人列表
     */
    void sendAttachmentsMail(String[] to, String subject, String content, String[] filePaths, String... cc);

    /**
     * 发送内嵌静态资源（图片）的富文本格式邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件正文
     * @param resources 静态资源map(编号, 本地资源目录)
     * @param cc 抄送人列表
     */
    void sendInlineResourcesMail(String[] to, String subject, String content, Map<String, String> resources, String... cc);
}

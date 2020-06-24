package com.example.lib_network.api

/**
 * @Describe
 * @Author Jungle68
 * @Date 2016/12/16
 * @Contact 335891510@qq.com
 */
object ApiConfig {
    /**
     * app名称，升级接口需要
     */
    const val APP_NAME = "ThinkTool"

    /**
     * 添加平台名称，用于接口
     * 1:pc 2:h5 3:ios 4:android 5:其他
     */
    const val ANDROID_PLATFORM = 4

    /**
     * 接口请求失败后，最大重复请求次数
     */
    const val DEFAULT_MAX_RETRY_COUNT = 5
    const val API_VERSION_2 = "v2"

    /**
     * 网络根地址  http://192.168.10.222/
     * 测试服务器：http://192.168.2.222:8080/mockjs/2/test-get-repose-head-normal?
     */
    const val APP_IS_NEED_SSH_CERTIFICATE = true // 自定义证书时使用false
    const val APP_OVERSEAS_FORMAL = "http://ithinkcar.com/" // 海外正式服务器
    var H5_PATH_FORMAL = "https://api.mythinkcar.com/" // H5页面的正式地址
    const val APP_DOMAIN_FORMAL = "http://sns.dadaaa.com/" // 国内正式服务器
    const val APP_RESOURCE_SERVER_URL =
        "http://d849tnjs91hjk.cloudfront.net/" //  亚马逊云cdn 地址
    var AWS_THINKCAR = "http://aws.ithinkcar.com/"
    const val APP_IS_TEST_ENVIRONMENT = false // APP接口域名是否是测试环境，默认不是

    /**
     * 接口域名切换 ，如果是release打包 =
     */
    var APP_DOMAIN =
        if (APP_IS_TEST_ENVIRONMENT) APP_DOMAIN_FORMAL else APP_OVERSEAS_FORMAL
    const val URL_ABOUT_US = "api/$API_VERSION_2/aboutus" // 关于我们网站
    const val URL_JIPU_SHOP = "http://demo.jipukeji.com" // 极铺购物地址
    const val URL_INTEGRATION_SHOP =
        "api/$API_VERSION_2/currency/shop" // 积分商城地址

    // 图片地址 V2
    const val IMAGE_PATH_V2_ORIGIN = "api/$API_VERSION_2/files/%s"
    const val IMAGE_PATH_V2 = "$IMAGE_PATH_V2_ORIGIN?w=%d&h=%d&q=%d"

    //个人相册墙地址 图片数据id (图片地址拼接为 域名/api/v2/files/id)
    val PERSONAL_IMG_PATH_V2 =
        APP_DOMAIN + "api/" + API_VERSION_2 + "/files/"

    //个人相视频地址 视频文件id 视频地址拼接为 域名/api/v2/files/video_id
    val PERSONAL_VIDEO_PATH_V2 =
        APP_DOMAIN + "api/" + API_VERSION_2 + "/files/"
    const val IMAGE_PATH_NQ = "$IMAGE_PATH_V2_ORIGIN?w=%d&h=%d"

    // 头像地址
    val IMAGE_AVATAR_PATH_V2 =
        APP_DOMAIN + "api/" + API_VERSION_2 + "/users/%s/avatar"

    // 音乐等文件地址 V2
    const val FILE_PATH = "api/$API_VERSION_2/files/%s"
    /*******************************************  接口 Path   */
    /**
     * 登录 Login
     */
    const val APP_PATH_LOGIN = "api/$API_VERSION_2/auth/login_new"

    /**
     * 密码 PasswordClient
     */
    const val APP_PATH_CHANGE_PASSWORD_V2 =
        "api/$API_VERSION_2/user/password" // com.us.thinkcar
    const val APP_PATH_FIND_PASSWORD_V2 =
        "api/$API_VERSION_2/user/retrieve-password" // 找回密码

    /**
     * 注册 RegitstClient
     */
    const val APP_PATH_REGISTER =
        "api/$API_VERSION_2/users/thinkToolReg" // 注册

    /**
     * 用户 UserInfoClient
     */
    const val APP_PATH_CHANGE_USER_INFO =
        "api/$API_VERSION_2/user" // 修改用户信息
    const val APP_PATH_GET_MY_DIGGS =
        "api/$API_VERSION_2/user/likes" // 获取用户收到的点赞
    const val APP_PATH_GET_MY_COMMENTS =
        "api/$API_VERSION_2/user/comments" // 获取用户收到的评论
    const val APP_PATH_GET_ALL_COMMENTS =
        "api/$API_VERSION_2/comments" // 按需求获取评论
    const val APP_PATH_GET_MY_ATMESSAGES =
        "api/$API_VERSION_2/user/message/atme" // 获取用户收到的@
    const val APP_PATH_UPDATE_USER_AVATAR =
        "api/$API_VERSION_2/user/avatar" // 修改用户头像
    const val APP_PATH_UPDATE_USER_BG =
        "api/$API_VERSION_2/user/bg" // 修改用户背景
    const val APP_PATH_UPDATE_USER_PHONE_OR_EMAIL =
        "api/$API_VERSION_2/user" // 更新认证用户的手机号码和邮箱
    const val APP_PATH_DELETE_USER_PHONE =
        "api/$API_VERSION_2/user/phone" // 解除用户 Phone 绑定
    const val APP_PATH_DELETE_USER_EMAIL =
        "api/$API_VERSION_2/user/email" // 解除用户 E-Mail 绑定
    const val APP_PATH_DELETE_USER_FRIENDS_LIST =
        "api/$API_VERSION_2/user/follow-mutual" // 好友列表
    const val APP_PATH_GET_CURRENT_USER_PERMISSION =
        "api/$API_VERSION_2/user/abilities" // 获取当前登录用户的权限

    // 用户标签
    const val APP_PATH_GET_USER_TAGS =
        "api/$API_VERSION_2/users/{user_id}/tags" // 获取一个用户的标签
    const val APP_PATH_GET_CURRENT_USER_TAGS =
        "api/$API_VERSION_2/user/tags" // 获取当前认证用户的标签
    const val APP_PATH_CURRENT_USER_ADD_TAGS =
        "api/$API_VERSION_2/user/tags/{tag_id}" // 当前认证用户附加一个标签
    const val APP_PATH_CURRENT_USER_DELETE_TAGS =
        "api/$API_VERSION_2/user/tags/{tag_id}" // 当前认证用户分离一个标签

    // 认证
    const val APP_PATH_CERTIFICATION =
        "api/$API_VERSION_2/user/certification" // GET-获取认证信息 POST-申请认证 PACTH-更新认证

    // 打赏
    const val APP_PATH_REWARD_USER =
        "api/$API_VERSION_2/user/{user_id}/new-rewards" // 打赏一个用户

    /**
     * 消息通知
     */
    // 未读通知数量检查
    const val APP_PATH_GET_CKECK_UNREAD_NOTIFICATION =
        "api/$API_VERSION_2/user/notifications"

    // 通知列表
    const val APP_PATH_GET_NOTIFICATION_LIST =
        "api/$API_VERSION_2/user/notifications"

    // 读取通知
    const val APP_PATH_GET_NOTIFICATION_DETIAL =
        "api/$API_VERSION_2/user/notifications/{notification}"

    // 标记通知阅读
    const val APP_PATH_MAKE_NOTIFICAITON_READED =
        "api/$API_VERSION_2/user/notifications/"

    // 标记所有通知已读
    const val APP_PATH_MAKE_NOTIFICAITON_ALL_READED =
        "api/$API_VERSION_2/user/notifications/all"

    // type  获取通知类型，可选 all,read,unread 默认 all
    const val NOTIFICATION_TYPE_ALL = "all"
    const val NOTIFICATION_TYPE_READ = "read"
    const val NOTIFICATION_TYPE_UNREAD = "unread "

    // 获取用户未读信息
    //    public static final String APP_PATH_GET_UNREAD_NOTIFICATION = "api/" + API_VERSION_2 + "/user/notification-statistics";
    const val APP_PATH_GET_UNREAD_NOTIFICATION =
        "api/$API_VERSION_2/user/unread-count"

    /**
     * 聊天相关
     */
    const val APP_PATH_GET_IM_INFO =
        "api/$API_VERSION_2/im/users" // 获取 IM 帐号信息

    /**
     * 获取环信用户密码，在这个接口中，后端会去判断是否已经有用户，没有则注册
     */
    const val APP_PATH_GET_IM_INFO_V2 =
        "api/$API_VERSION_2/easemob/password"
    const val APP_PATH_CREATE_CONVERSAITON =
        "api/$API_VERSION_2/im/conversations" // 创建对话
    const val APP_PATH_GET_CONVERSAITON_LIST =
        "api/$API_VERSION_2/im/conversations/list/all" // 获取登陆用户的对话列表
    const val APP_PATH_GET_SINGLE_CONVERSAITON =
        "api/$API_VERSION_2/im/conversations/{cid}" // 获取单个对话信息
    const val APP_PATH_CREATE_CHAT_GROUP =
        "api/$API_VERSION_2/easemob/group" // 创建群聊
    const val APP_PATH_GET_GROUP_INFO =
        "api/$API_VERSION_2/easemob/group?im_group_id=%s" // 获取群信息
    const val APP_PATH_GET_GROUP_INFO_S =
        "api/$API_VERSION_2/easemob/group" // 获取群信息
    const val APP_PATH_GET_GROUP_INFO_S_FACE =
        "api/$API_VERSION_2/easemob/groups" // 获取群信息,只返回群头像，
    const val APP_PATH_GET_GROUP_ADD_MEMBER =
        "api/$API_VERSION_2/easemob/group/member" // 修改成员 添加POST 移除delete

    /**
     * 关注粉丝 FollowFansClient
     */
    const val APP_PATH_FOLLOW_LIST =
        "api/$API_VERSION_2/users/{user_id}/followings" // 获取用户关注列表
    const val APP_PATH_FANS_LIST =
        "api/$API_VERSION_2/users/{user_id}/followers" // 获取用户粉丝列表
    const val APP_PATH_FOLLOW_USER =
        "api/$API_VERSION_2/user/followings/{user_id}" // 关注用户
    const val APP_PATH_FOLLOW_USER_FORMART =
        "api/$API_VERSION_2/user/followings/%d" // 关注用户
    const val APP_PATH_CANCEL_FOLLOW_USER =
        "api/$API_VERSION_2/user/followings/{user_id}" // 取消用户关注
    const val APP_PATH_CANCEL_FOLLOW_USER_FORMART =
        "api/$API_VERSION_2/user/followings/%d" // 取消用户关注

    /**
     * 动态相关
     */
    const val APP_PATH_SEND_DYNAMIC_V2 =
        "api/$API_VERSION_2/feeds" // 发布动态 V2

    // 删除一条动态
    const val APP_PATH_DELETE_DYNAMIC =
        "api/$API_VERSION_2/feeds/%s/currency"

    // 获取动态列表
    const val DYNAMIC_TYPE_EMPTY = "empty" // 占位
    const val DYNAMIC_TYPE_NEW = "new" // 最新动态
    const val DYNAMIC_TYPE_FOLLOWS = "follow" // 关注动态
    const val DYNAMIC_TYPE_HOTS = "hot" // 热门动态
    const val DYNAMIC_TYPE_USERS = "users" // 用户动态
    const val DYNAMIC_TYPE_SOMEONE = "users/%s" // 某个人的动态列表,%s表示用户id
    const val DYNAMIC_TYPE_MY_COLLECTION = "collections" // 我收藏的动态列表

    // 点赞一条动态,取消点赞
    const val APP_PATH_DYNAMIC_CLICK_LIKE_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/like"
    const val APP_PATH_DYNAMIC_CANCEL_CLICK_LIKE_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/unlike"
    const val APP_PATH_DYNAMIC_CLICK_LIKE_FORMAT_V2 =
        "api/$API_VERSION_2/feeds/%s/like"
    const val APP_PATH_DYNAMIC_CANCEL_CLICK_LIKE_FORMAT_V2 =
        "api/$API_VERSION_2/feeds/%s/unlike"

    //对评论进行点赞，取消评论点赞
    const val APP_PATH_DYNAMIC_COMMENT_LIKE =
        "api/$API_VERSION_2/feeds/commentLike"
    const val APP_PATH_DYNAMIC_COMMENT_UNLIKE =
        "api/$API_VERSION_2/feeds/commentLikeCancel"

    // 删除一条评论评论
    const val APP_PATH_DYNAMIC_DELETE_COMMENT_V2 =
        "api/$API_VERSION_2/feeds/%s/comments/%s"

    // 对一条动态或一条动态评论进行评论
    const val APP_PATH_DYNAMIC_SEND_COMMENT_V2 =
        "api/$API_VERSION_2/feeds/%s/comments"

    // 获取点赞列表
    const val APP_PATH_DYNAMIC_DIG_LIST_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/likes"

    // 一条动态的评论列表
    const val APP_PATH_DYNAMIC_COMMENT_LIST_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/comments"

    // 获取动态详情 V2
    const val APP_PATH_GET_DYNAMIC_DETAIL =
        "api/$API_VERSION_2/feeds/{feed_id}"

    // 获取动态列表 V2
    const val APP_PATH_GET_DYNAMIC_LIST_V2 = "api/$API_VERSION_2/feeds" //
    const val APP_PATH_GET_COLLECT_DYNAMIC_LIST_V2 =
        "api/$API_VERSION_2/feeds/collections"

    // 设置动态评论收费 V2
    const val APP_PATH_COMMENT_PAID_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/comment-paid"
    const val APP_PATH_COMMENT_PAID_V2_FORMAT =
        "api/$API_VERSION_2/feeds/%d/comment-paid"

    // 置顶动态 V2
    const val APP_PATH_TOP_DYNAMIC =
        "api/$API_VERSION_2/feeds/{feed_id}/currency-pinneds"

    // 置顶动态评论 V2
    const val APP_PATH_TOP_DYNAMIC_COMMENT =
        "api/$API_VERSION_2/feeds/{feed_id}/comments/{comment_id}/currency-pinneds"

    // 动态评论置顶审核列表 V2
    const val APP_PATH_REVIEW_DYNAMIC_COMMENT = "api/" + API_VERSION_2 +
            "/user/feed-comment-pinneds"

    // 同意动态评论置顶 V2
    const val APP_PATH_APPROVED_DYNAMIC_COMMENT = "api/" + API_VERSION_2 +
            "/feeds/{feed_id}/comments/{comment_id}/currency-pinneds/{pinned_id}"

    // 拒绝动态评论置顶 V2
    const val APP_PATH_REFUSE_DYNAMIC_COMMENT = "api/" + API_VERSION_2 +
            "/user/feed-comment-currency-pinneds/{pinned_id}"

    // 删除动态评论置顶 V2
    const val APP_PATH_DELETE_DYNAMIC_COMMENT = "api/" + API_VERSION_2 +
            "/feeds/{feed_id}/comments/{comment_id}/unpinned"

    // 收藏动态，取消收藏 V2
    const val APP_PATH_HANDLE_COLLECT_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/collections"
    const val APP_PATH_HANDLE_COLLECT_V2_FORMAT =
        "api/$API_VERSION_2/feeds/%s/collections"
    const val APP_PATH_HANDLE_UNCOLLECT_V2 =
        "api/$API_VERSION_2/feeds/{feed_id}/uncollect"
    const val APP_PATH_HANDLE_UNCOLLECT_V2_FORMAT =
        "api/$API_VERSION_2/feeds/%s/uncollect"

    // 动态打赏
    const val APP_PATH_DYNAMIC_REWARDS =
        "/api/$API_VERSION_2/feeds/{feed_id}/new-rewards"

    // 动态打赏用户列表
    const val APP_PATH_DYNAMIC_REWARDS_USER_LIST =
        "/api/$API_VERSION_2/feeds/{feed_id}/rewards"

    // 举报动态
    const val APP_PATH_DYNAMIC_REPORT =
        "/api/$API_VERSION_2/feeds/{feed_id}/reports"

    // 获取动态置顶平均积分
    const val APP_PATH_DYNAMIC_TOP_AVERAGE_NUM =
        "/api/$API_VERSION_2/feeds/average"

    // 获取用户照片列表
    const val APP_PATH_DYNAMIC_GET_PHOTOLIST =
        "/api/$API_VERSION_2/feeds/imgList"

    // 获取用户视频列表
    const val APP_PATH_DYNAMIC_GET_VIDEOLIST =
        "/api/$API_VERSION_2/feeds/videoList"

    /**
     * feed-topic
     */
    // 话题
    const val APP_PATH_TOPICS = "/api/$API_VERSION_2/feed/topics"

    // 获取话题下的动态列表
    const val APP_PATH_GET_TOPIC_DYNAMIC =
        "/api/$API_VERSION_2/feed/topics/{topic_id}/feeds"

    // 编辑一个话题
    const val APP_PATH_MODIFY_TOPICS =
        "/api/$API_VERSION_2/feed/topics/{topic_id}"

    // 获取话题下的参与者列表
    const val APP_PATH_GET_TOPIC_PARTICIPANTS =
        "/api/$API_VERSION_2/feed/topics/{topic_id}/participants"

    // 关注一个话题
    const val APP_PATH_FOLLOW_TOPICS =
        "/api/$API_VERSION_2/user/feed-topics/{topic_id}"
    const val APP_PATH_FOLLOW_TOPICS_FORMAT =
        "api/$API_VERSION_2/user/feed-topics/%d"

    // 获取一个话题详情
    const val APP_PATH_GET_TOPICDETAIL =
        "/api/$API_VERSION_2/feed/topics/{topic_id}"

    // 举报一个话题
    const val APP_PATH_REPORT_TOPIC =
        "/api/$API_VERSION_2/user/report-feed-topics/{topic_id}"

    /**
     * 资讯相关
     */
    const val INFO_TYPE_COLLECTIONS = "-1000" // 资讯收藏列表

    // 资讯投稿
    const val APP_PATH_PUBLISH_INFO =
        "api/$API_VERSION_2/news/categories/{category}/currency-news"

    // 修改资讯投稿
    const val APP_PATH_UPDATE_INFO =
        "api/$API_VERSION_2/news/categories/{category_id}/news/{news_id}"

    // 订阅资讯频道
    const val APP_PATH_INFO_FOLLOW_LIST =
        "api/$API_VERSION_2/news/categories/follows"

    //置顶资讯、评论
    const val APP_PATH_TOP_INFO =
        "/api/$API_VERSION_2/news/{news_id}/currency-pinneds"
    const val APP_PATH_TOP_INFO_COMMENT =
        "/api/$API_VERSION_2/news/{news_id}/comments/{comment_id}/currency-pinneds"

    // 资讯评论平均金额
    const val APP_PATH_INFO_TOP_AVERAGE_NUM =
        "/api/$API_VERSION_2/news/average"

    // 咨询打赏
    const val APP_PATH_INFO_REWARDS =
        "/api/$API_VERSION_2/news/{news_id}/new-rewards"

    // 打赏用户列表
    const val APP_PATH_INFO_REWARDS_USER_LIST =
        "/api/$API_VERSION_2/news/{news_id}/rewards"

    // 咨询举报
    const val APP_PATH_INFO_REPORT =
        "/api/$API_VERSION_2/news/{news_id}/reports"

    // 资讯打赏统计
    const val APP_PATH_INFO_REWARDS_COUNT =
        "/api/$API_VERSION_2/news/{news_id}/rewards/sum"

    // 获取用户投稿列表
    const val APP_PATH_GET_MY_INFO =
        "/api/$API_VERSION_2/user/news/contributes"

    // 查看资讯中申请置顶的评论列表
    const val APP_PATH_GET_REVIEW_INFO_COMMENT =
        "/api/$API_VERSION_2/news/comments/pinneds"

    // 同意资讯评论置顶
    const val APP_PATH_APPROVED_INFO_COMMENT = "/api/" + API_VERSION_2 +
            "/news/{news_id}/comments/{comment_id}/currency-pinneds/{pinned_id}"

    // 拒绝资讯评论置顶
    const val APP_PATH_REFUSE_INFO_COMMENT = "/api/" + API_VERSION_2 +
            "/news/{news_id}/comments/{comment_id}/currency-pinneds/{pinned_id}/reject"

    /**
     * 音乐相关 升级到V2
     */
    const val APP_PATH_MUSIC_ABLUM_LIST =
        "api/$API_VERSION_2/music/specials" // 专辑列表
    const val APP_PATH_MUSIC_COLLECT_ABLUM_LIST =
        "api/$API_VERSION_2/music/collections" // 收藏的专辑列表

    // 歌曲详情
    const val APP_PATH_MUSIC_DETAILS =
        "api/$API_VERSION_2/music/{music_id}"

    // 购买的单曲
    const val APP_PATH_MUSIC_PAIDS = "api/$API_VERSION_2/music/paids"

    // 购买的专辑
    const val APP_PATH_MUSIC_ALBUM_PAIDS =
        "api/$API_VERSION_2/music-specials/paids"

    // 评论歌曲
    const val APP_PATH_MUSIC_COMMENT =
        "api/$API_VERSION_2/music/{music_id}/comments"
    const val APP_PATH_MUSIC_COMMENT_FORMAT =
        "api/$API_VERSION_2/music/%s/comments"

    // 批量获取音乐
    const val APP_PATH_GET_MUSICS = "api/$API_VERSION_2/music/songs"

    // 删除音乐评论
    const val APP_PATH_MUSIC_DELETE_COMMENT_FORMAT =
        "api/$API_VERSION_2/music/%d/comments/%d"
    const val APP_PATH_MUSIC_DELETE_COMMENT =
        "api/$API_VERSION_2/music/{music_id}/comments/{comment_id}"

    // 评论专辑
    const val APP_PATH_MUSIC_ABLUM_COMMENT =
        "api/$API_VERSION_2/music/specials/{special_id}/comments"
    const val APP_PATH_MUSIC_ABLUM_COMMENT_FORMAT =
        "api/$API_VERSION_2/music/specials/%s/comments"

    // 专辑评论列表
    const val APP_PATH_MUSIC_ABLUM_COMMENT_LIST =
        "api/$API_VERSION_2/music/specials/{special_id}/comments"

    // 收藏专辑
    const val APP_PATH_MUSIC_ABLUM_COLLECT =
        "api/$API_VERSION_2/music/specials/{special_id}/collection"
    const val APP_PATH_MUSIC_ABLUM_COLLECT_FORMAT =
        "api/$API_VERSION_2/music/specials/%s/collection"

    // 音乐点赞
    const val APP_PATH_MUSIC_DIGG =
        "api/$API_VERSION_2/music/{music_id}/like"
    const val APP_PATH_MUSIC_DIGG_FORMAT =
        "api/$API_VERSION_2/music/%s/like"

    // 专辑详情
    const val APP_PATH_MUSIC_ABLUM_DETAILS =
        "api/$API_VERSION_2/music/specials/{special_id}"
    /**
     * *******************************问答相关 */
    /**
     * 问答配置
     */
    const val APP_PATH_GET_QUESTIONS_CONFIG =
        "api/$API_VERSION_2/question-configs"

    /**
     * 发布问题
     */
    const val APP_PATH_PUBLISH_QUESTIONS =
        "api/$API_VERSION_2/currency-questions"
    const val APP_PATH_GET_QUESTIONS_LSIT = "api/$API_VERSION_2/questions"

    /**
     * 更新问题的悬赏 PATCH
     */
    const val APP_PATH_UPDATE_QUESTION_REWARD =
        "api/$API_VERSION_2/currency-questions/{question}/amount"

    /**
     * 获取全部话题
     */
    const val APP_PATH_GET_ALL_TOPIC =
        "api/$API_VERSION_2/question-topics"

    /**
     * 申请创建话题
     */
    const val APP_PATH_CREATE_TOPIC =
        "api/$API_VERSION_2/user/question-topics/application"

    /**
     * 获取认证用户关注的话题或者专家话题
     */
    const val APP_PATH_GET_FOLLOW_TOPIC =
        "api/$API_VERSION_2/user/question-topics"

    /**
     * 获取话题下专家列表
     */
    const val APP_PATH_GET_TOPIC_EXPERTS =
        "api/$API_VERSION_2/question-topics/{topic_id}/experts"

    /**
     * 话题详情
     */
    const val APP_PATH_GET_TOPIC_DETAIL =
        "api/$API_VERSION_2/question-topics/{topic}"

    /**
     * 话题下的问答列表
     */
    const val APP_PATH_GET_QUESTION_LIST_BY_TOPIC =
        "api/$API_VERSION_2/question-topics/{topic}/questions"

    /**
     * 关注或者取消一个话题
     */
    const val APP_PATH_HANDLE_TOPIC_FOLLOW =
        "api/$API_VERSION_2/user/question-topics/{topic}"
    const val APP_PATH_HANDLE_TOPIC_FOLLOW_S =
        "api/$API_VERSION_2/user/question-topics/%s"

    /**
     * 获取问题详情
     */
    const val APP_PATH_GET_QUESTION_DETAIL =
        "api/$API_VERSION_2/questions/{question}"
    const val APP_PATH_UPDATE_QUESTION_DETAIL =
        "api/$API_VERSION_2/currency-questions/{question}"

    /**
     * 关注问题
     */
    const val APP_PATH_HANDLE_QUESTION_FOLLOW =
        "api/$API_VERSION_2/user/question-watches/{question}"
    const val APP_PATH_HANDLE_QUESTION_FOLLOW_S =
        "api/$API_VERSION_2/user/question-watches/%s"

    /**
     * 删除问题用
     */
    const val APP_PATH_GET_DELETE_QUESTION =
        "api/$API_VERSION_2/currency-questions/{question}"

    /**
     * 管理员删除问题用
     */
    const val APP_PATH_GET_MANAGERDELETE_QUESTION =
        "api/$API_VERSION_2/qa/questions/{question}"

    /**
     * 获取一个问题的回答列表
     */
    const val APP_PATH_GET_QUESTION_ANSWER_LIST =
        "api/$API_VERSION_2/questions/{question}/answers"

    /**
     * 获取转发的回答列表
     */
    const val APP_PATH_GET_SIMPLE_QUESTION_ANSWER_LIST =
        "api/$API_VERSION_2/qa/reposted-answers"

    /**
     * 获取一个回答的详情
     */
    const val APP_PATH_GET_ANSWER_DETAIL =
        "api/$API_VERSION_2/question-answers/{answer_id}"
    const val APP_PATH_GET_ANSWER_DETAIL_S =
        "api/$API_VERSION_2/question-answers/%s"

    /**
     * 申请精选问答 POST
     */
    const val APP_PATH_APPLY_FOR_EXCELLENT =
        "api/$API_VERSION_2/user/currency-question-application/{question}"

    /**
     * 获取问答的评论列表
     */
    const val APP_PATH_GET_QUESTION_COMMENT_LIST =
        "api/$API_VERSION_2/questions/{question}/comments"

    /**
     * 评论问题
     */
    const val APP_PATH_SEND_QUESTION_COMMENT =
        "api/$API_VERSION_2/questions/{question}/comments"
    const val APP_PATH_SEND_QUESTION_COMMENT_S =
        "api/$API_VERSION_2/questions/%s/comments"

    /**
     * 删除问题的评论
     */
    const val APP_PATH_DELETE_QUESTION_COMMENT =
        "api/$API_VERSION_2/questions/{question}/comments/{answer}"

    /**
     * 回答问题
     */
    const val APP_PATH_PUBLISH_ANSWER =
        "api/$API_VERSION_2/currency-questions/{question}/answers"

    /**
     * 更新回答 PATCH
     */
    const val APP_PATH_UPDATE_ANSWER =
        "api/$API_VERSION_2/question-answers/{answer_id}"

    /**
     * 采纳答案 PUT
     */
    const val APP_PATH_ADOPT_ANSWER =
        "api/$API_VERSION_2/questions/{question_id}/currency-adoptions/{answer_id}"

    /**
     * 删除答案 DELETE
     */
    const val APP_PATH_DELETE_ANSWER =
        "api/$API_VERSION_2/question-answers/{answer}"
    const val APP_PATH_DELETE_ANSWER_S =
        "api/$API_VERSION_2/question-answers/%d"
    const val APP_PATH_MANAGER_DELETE_ANSWER_S =
        "api/$API_VERSION_2/qa/answers/%d"

    /**
     * 获取回答评论列表
     */
    const val APP_PATH_GET_ANSWER_COMMENTS =
        "api/$API_VERSION_2/question-answers/{answer_id}/comments"

    /**
     * 点赞回答
     */
    const val APP_PATH_LIKE_ANSWER =
        "api/$API_VERSION_2/question-answers/{answer_id}/likes"
    const val APP_PATH_LIKE_ANSWER_FORMAT =
        "api/$API_VERSION_2/question-answers/%d/likes"

    /**
     * 收藏回答
     */
    const val APP_PATH_COLLECT_ANSWER_FORMAT =
        "api/$API_VERSION_2/user/question-answer/collections/%d"

    /**
     * 回答收藏列表
     */
    const val APP_PATH_USER_COLLECT_ANSWER_FORMAT =
        "api/$API_VERSION_2/user/question-answer/collections"

    /**
     * 问答回答打赏
     */
    const val APP_PATH_QA_ANSWER_REWARD =
        "api/$API_VERSION_2/question-answers/{answer_id}/new-rewards"

    /**
     * 问答回答围观
     */
    const val APP_PATH_QA_ANSWER_LOOK =
        "api/$API_VERSION_2/question-answers/{answer_id}/currency-onlookers"

    /**
     * 获取回答打赏列表
     */
    const val APP_PATH_QA_ANSWER_REWARD_USER_LIST =
        "api/$API_VERSION_2/question-answers/{answer_id}/rewarders"

    /**
     * 问答问题举报
     */
    const val APP_PATH_QA_REPORT =
        "api/$API_VERSION_2/questions/{question_id}/reports"

    /**
     * 问答回答举报
     */
    const val APP_PATH_QA_ANSWER_REPORT =
        "api/$API_VERSION_2/question-answers/{answer_id}/reports"

    /**
     * 评论答案
     */
    const val APP_PATH_COMMENT_QA_ANSWER_FORMAT =
        "api/$API_VERSION_2/question-answers/%d/comments"

    /**
     * 删除答案评论
     */
    const val APP_PATH_DELETE_QA_ANSWER_COMMENT_FORMAT =
        "api/$API_VERSION_2/question-answers/%d/comments/%d"

    /**
     * 批量获取专家列表
     */
    const val APP_PATH_GET_TOPIC_EXPERT_LIST =
        "api/$API_VERSION_2/question-experts"

    /**
     * 获取用户发布的问题列表
     */
    const val APP_PATH_GET_USER_QUESTIONS =
        "api/$API_VERSION_2/user/questions"

    /**
     * 获取用户发布的回答列表
     */
    const val APP_PATH_GET_USER_ANSWER =
        "api/$API_VERSION_2/user/question-answer"

    /**
     * **************************通用 CommonClient
     */
    const val APP_PATH_REFRESH_TOKEN =
        "api/$API_VERSION_2/auth/refresh" // 刷新 token
    const val APP_PATH_HANDLE_BACKGROUND_TASK = "{path}" // 处理后台任务
    const val APP_PATH_SYSTEM_FEEDBACK =
        "api/$API_VERSION_2/user/feedback" // 意见反馈
    const val APP_PATH_GET_SYSTEM_CONVERSATIONS =
        "api/$API_VERSION_2/conversations" // 获取系统会话列表

    ////////////////////////////////////////// 以下是通用 V2 接口
    const val APP_PATH_STORAGE_HASH =
        "api/$API_VERSION_2/files/uploaded/{hash}" // 校检文件hash V2
    const val APP_PATH_GET_CHECK_NOTE =
        "api/$API_VERSION_2/purchases/{note}" // 节点付费相关
    const val APP_PATH_CHECK_NOTE =
        "api/$API_VERSION_2/currency/purchases/{note}" // 节点付费相关
    const val APP_PATH_STORAGE_UPLAOD_FILE =
        "api/$API_VERSION_2/files" // 文件上传 V2

    /**
     * 创建上传任务 2018-9-6 15:12:06
     */
    const val APP_PATH_STORAGE_UPLAOD = "api/$API_VERSION_2/storage"

    /**
     * 上传文件标识头信息
     */
    const val APP_PATH_STORAGE_HEADER_FLAG = "tsplus_upload"
    const val APP_PATH_STORAGE_GET_FILE =
        "api/$API_VERSION_2/files/{file}" // 文件获取 V2

    // 标签
    const val APP_PATH_GET_ALL_TAGS =
        "api/$API_VERSION_2/tags" // 获取全部标签标签

    // 地区
    const val APP_PATH_SEARDCH_LOCATION =
        "api/$API_VERSION_2/locations/search" // 搜索位置
    const val APP_PATH_SGET_HOT_CITY =
        "api/$API_VERSION_2/locations/hots" // 热门城市

    /**
     * 举报评论通用，除圈子评论
     */
    const val APP_PATH_REPORT_COMMON_COMMENT =
        "api/$API_VERSION_2/report/comments/{comment_id}"

    /**
     * 分享相关
     * urls = [
     * /users/{user}：用户主页
     * /feeds/{feed}：动态详情
     * /news/{news}：资讯详情页面
     * /questions/{question}：问题详情
     * /questions/{question}/answers/{answer}：回答详情
     * /groups/{group}?type={?fetch-posts-type}：圈子详情
     * /groups/{group}/posts/{post}：帖子详情
     * /question-topics/{topic} 话题
     * ]
     * 上述为「app, pc, h5」需要分享到第三方的页面,分享页面target的值要进行url编码，编码规范RFC 3986
     * 为了使用户有更好的浏览体验, 分享的出去的内容能够根据用户使用的客户端进行最佳的适配阅读,
     * 所以将分享出去的url统一为中间跳转的形式
     * 形式为: domain.com/redirect?target=urls[上面列举的url之一] 比如分享了用户主页
     * 分享出去的地址为: http://test-plus.zhibocloud.cn/redirect?target=/users/5
     */
    const val APP_SHARE_URL_FORMAT = "redirect?target="
    const val APP_SHARE_URL_PLATFORM = "?from=$ANDROID_PLATFORM"
    const val APP_SHARE_URL_PLATFORM_2 = "&from=$ANDROID_PLATFORM"

    // 开发中
    const val APP_PATH_SHARE_DEFAULT = "api/develop"

    // 用户二维码
    const val APP_PATH_SHARE_USERINFO_QR = "/users/%s"

    // 用户分享
    const val APP_PATH_SHARE_USERINFO = "/users/%s$APP_SHARE_URL_PLATFORM"

    // 动态分享
    const val APP_PATH_SHARE_DYNAMIC = "/feeds/%s$APP_SHARE_URL_PLATFORM"

    // 资讯详情网页
    const val APP_PATH_INFO_DETAILS_FORMAT = "/news/%s$APP_SHARE_URL_PLATFORM"

    // 圈子分享
    const val APP_PATH_SHARE_GROUP =
        "/groups/%1\$s?type=%2\$s$APP_SHARE_URL_PLATFORM_2"

    // feed-topic
    const val APP_PATH_SHARE_TOPIC =
        "/feed/topics/%1\$s?type=%2\$s$APP_SHARE_URL_PLATFORM_2"

    // 圈子帖子分享
    const val APP_PATH_SHARE_GROUNP_DYNAMIC =
        "/groups/%1\$s/posts/%2\$s$APP_SHARE_URL_PLATFORM"

    // 问答详情分享
    const val APP_PATH_SHARE_QA_QUESTION_DETAIL =
        "/questions/%s$APP_SHARE_URL_PLATFORM"

    // 问答回答分享
    const val APP_PATH_SHARE_QA_ANSWER_DETAIL =
        "/questions/%1\$s/answers/%2\$s$APP_SHARE_URL_PLATFORM"

    // 话题分享
    const val APP_PATH_SHARE_QA_TOPIC =
        "/question-topics/%s$APP_SHARE_URL_PLATFORM"

    // 分享歌曲,增加分享数
    const val APP_PATH_MUSIC_SHARE = "api/$API_VERSION_2/music/%s/share"

    // 分享专辑，增加分享数
    const val APP_PATH_MUSIC_ABLUM_SHARE =
        "api/$API_VERSION_2/music/specials/%s/share"

    /**
     * 仅仅测试使用
     */
    const val APP_PATH_TOKEN_EXPIERD = "api/music_window_rotate-token" // token过期处理

    /**
     * 圈子相关
     */
    const val APP_PATH_GET_ALL_GROUP =
        "api/$API_VERSION_2/groups" // 所有的圈子列表/如果是post,则是创建圈子
    const val APP_PATH_GET_USER_JOINED_GROUP =
        "api/$API_VERSION_2/groups/joined" // 用户加入的圈子
    const val APP_PATH_JOIN_GROUP =
        "api/$API_VERSION_2/groups/{group}/join" // 加入/退出圈子
    const val APP_PATH_JOIN_GROUP_S =
        "api/$API_VERSION_2/groups/%s/join" // 加入/退出圈子
    const val APP_PATH_GET_GROUP_DETAIL =
        "api/$API_VERSION_2/groups/{group}" // 圈子详情
    const val APP_PATH_GET_GROUP_DYNAMIC_DETAIL =
        "api/$API_VERSION_2/groups/{group}/posts/{post}" // 动态详情
    const val APP_PATH_GET_GROUP_DYNAMIC_LIST =
        "api/$API_VERSION_2/groups/{group}/posts" // 动态列表
    const val APP_PATH_DELETE_GROUP_DYNAMIC_COLLECT =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/collection" //

    // 取消对圈子动态的收藏
    const val APP_PATH_COLLECT_GROUP_DYNAMIC =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/collection" // 收藏圈子动态
    const val APP_PATH_COLLECT_GROUP_DYNAMIC_S =
        "api/$API_VERSION_2/groups/%s/posts/%s/collection" // 收藏圈子动态
    const val APP_PATH_GET_MYCOLLECT_GROUP_DYNAMIC_LIST =
        "api/$API_VERSION_2/groups/posts/collections" // 我收藏的圈子动态列表
    const val APP_PATH_DELETE_MYCOLLECT_GROUP_DYNAMIC_DIGG =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/like" // 取消点赞
    const val APP_PATH_DIGG_MYCOLLECT_GROUP_DYNAMIC =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/like" // 点赞
    const val APP_PATH_DIGG_MYCOLLECT_GROUP_DYNAMIC_S =
        "api/$API_VERSION_2/groups/%s/posts/%s/like" // 点赞
    const val APP_PATH_GET_MYCOLLECT_GROUP_DYNAMIC_DIGG_LIST =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/likes" // 点赞列表
    const val APP_PATH_COMMENT_GROUP_DYNAMIC =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/comments" // 创建圈子动态评论
    const val APP_PATH_COMMENT_GROUP_DYNAMIC_FORMAT =
        "api/$API_VERSION_2/plus-group/group-posts/%d/comments" // 创建圈子动态评论
    const val APP_PATH_GET_GROUP_DYNAMIC_COMMENT_LIST =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/comments" // 圈子动态评论列表
    const val APP_PATH_DELETE_GROUP_DYNAMIC_COMMENT =
        "api/$API_VERSION_2/groups/{group}/posts/{post}/comments/{comment}"

    // 删除圈子动态评论
    const val APP_PATH_DELETE_GROUP_DYNAMIC_COMMENT_FORMAT =
        "api/$API_VERSION_2/groups/%d/posts/%d/comments/%d" // 删除圈子动态评论
    const val APP_PATH_SEND_GROUP_DYNAMIC =
        "api/$API_VERSION_2/groups/{group}/posts" // 创建圈子动态
    const val APP_PATH_DELETE_GROUP_DYNAMIC =
        "api/$API_VERSION_2/groups/{group}/posts/{post}" // 删除圈子动态
    const val APP_PATH_DELETE_GROUP_DYNAMIC_FORMAT =
        "api/$API_VERSION_2/groups/%d/posts/%d" // 删除圈子动态
    // 2017年11月27日16:51:15 圈子在这里翻开了崭新的篇章
    /**
     * 获取圈子分类
     */
    const val APP_PATH_GET_CIRCLE_CATEGROIES =
        "api/$API_VERSION_2/plus-group/categories"

    /**
     * 推荐的圈子
     */
    const val APP_PATH_GET_RECOMMEND_CIRCLE =
        "api/$API_VERSION_2/plus-group/recommend/groups"

    /**
     * 我加入的圈子
     */
    const val APP_PATH_GET_MY_JOINED_CIRCLE =
        "api/$API_VERSION_2/plus-group/user-groups"

    /**
     * 全部圈子
     */
    const val APP_PATH_GET_ALL_CIRCLE =
        "api/$API_VERSION_2/plus-group/groups"

    /**
     * 圈子个数
     */
    const val APP_PATH_GET_CIRCLE_COUNT =
        "api/$API_VERSION_2/plus-group/groups/count"

    /**
     * 圈子待审核成员列表
     */
    const val APP_PATH_GET_CIRCLE_MEMBER_JOIN =
        "api/$API_VERSION_2/plus-group/user-group-audit-members"

    /**
     * 审核圈子加入请求
     */
    const val APP_PATH_DEAL_CIRCLE_MEMBER_JOIN = "api/" + API_VERSION_2 +
            "/plus-group/currency-groups/{circle_id}/members/{member_id}/audit"

    /**
     * 加入圈子
     */
    const val APP_PATH_PUT_JOIN_CIRCLE =
        "api/$API_VERSION_2/plus-group/currency-groups/{circle_id}"

    /**
     * 指定/撤销圈子管理员职位
     */
    const val APP_PATH_DEAL_CIRCLE_MANAGER =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/managers/{member_id}"

    /**
     * 踢出圈子
     */
    const val APP_PATH_CANCEL_CIRCLE_MEMBERS =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/members/{member_id}"

    /**
     * 加入/移除圈子黑名单
     */
    const val APP_PATH_DEAL_CIRCLE_BLACKLIST =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/blacklist/{member_id}"

    /**
     * 退出圈子
     */
    const val APP_PATH_PUT_EXIT_CIRCLE =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/exit"
    const val APP_PATH_PUT_EXIT_CIRCLE_FROMAT =
        "api/$API_VERSION_2/plus-group/groups/%s/exit"

    /**
     * 设置圈子权限
     */
    const val APP_PATH_SET_CIRCLE_PERMISSIONS =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/permissions"

    /**
     * 创建圈子
     */
    const val APP_PATH_CREATE_CIRCLE =
        "api/$API_VERSION_2/plus-group/categories/{category_id}/groups"

    /**
     * 获取圈子协议
     */
    const val APP_PATH_GET_CREATE_RULE =
        "api/$API_VERSION_2/plus-group/groups/protocol"

    /**
     * 圈子收入记录
     */
    const val APP_PATH_GET_CIRCLE_EARNINGLIST =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/incomes"

    /**
     * 获取圈子列表
     */
    const val APP_PATH_GET_CIRCLELIST =
        "api/$API_VERSION_2/plus-group/categories/{category_id}/groups "

    /**
     * 获取附近圈子列表
     */
    const val APP_PATH_GET_ROUNDCIRCLE =
        "api/$API_VERSION_2/plus-group/round/groups "

    /**
     * 获取圈子详情
     */
    const val APP_PATH_GET_CIRCLEDETAIL =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}"

    /**
     * 圈子发帖
     */
    const val APP_PATH_PUBLISH_POST =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/posts"

    /**
     * 获取圈子成员列表
     */
    const val APP_PATH_GET_CIRCLEMEMBERS =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/members"

    /**
     * 转让圈子
     */
    const val APP_PATH_ATTORN_CIRCLE =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/owner"

    /**
     * 获取圈子下帖子列表
     */
    const val APP_PATH_GET_POSTLIST =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/posts"

    /**
     * 获取预览帖子列表
     */
    const val APP_PATH_GET_PRE_POSTLIST =
        "api/$API_VERSION_2/group/groups/{circle_id}/preview-posts"
    const val APP_PATH_GET_POSTLIST_BY_ID =
        "api/$API_VERSION_2/group/simple-posts"

    /**
     * 获取我的帖子列表
     */
    const val APP_PATH_GET_MINE_POSTLIST =
        "api/$API_VERSION_2/plus-group/user-group-posts"

    /**
     * 全部帖子列表包含搜索
     */
    const val APP_PATH_GET_ALL_POSTLIST =
        "api/$API_VERSION_2/plus-group/group-posts"

    /**
     * 圈子成员角色统计
     */
    const val APP_PATH_GET_GROUP_MEMBER_COUNT =
        "api/$API_VERSION_2/plus-group/groups/{group_id}/role/count"

    /**
     * 用户帖子收藏列表
     */
    const val APP_PATH_GET_USER_COLLECT_POST =
        "api/$API_VERSION_2/plus-group/user-post-collections"

    /**
     * 评论帖子/评论列表
     */
    const val APP_PATH_COMMENT_POST =
        "api/$API_VERSION_2/plus-group/group-posts/{post_id}/comments"
    const val APP_PATH_COMMENT_POST_FORMAT =
        "api/$API_VERSION_2/plus-group/group-posts/%s/comments"

    /**
     * 帖子点赞
     */
    const val APP_PATH_LIKE_POST_FORMAT =
        "api/$API_VERSION_2/plus-group/group-posts/%s/likes"
    const val APP_PATH_LIKE_POST =
        "api/$API_VERSION_2/plus-group/group-posts/{post_id}/likes"

    /**
     * 帖子置顶
     */
    const val APP_PATH_TOP_POST =
        "api/$API_VERSION_2/plus-group/currency-pinned/posts/{post_id}"

    /**
     * 帖子、评论置顶平均金额
     */
    const val APP_PATH_TOP_POST_AVERAGE_NUM =
        "api/$API_VERSION_2/plus-group/average"

    /**
     * 圈主和管理员置顶帖子
     */
    const val APP_PATH_MANAGER_TOP_POST =
        "api/$API_VERSION_2/plus-group/pinned/posts/{post_id}/create"

    /**
     * 圈主和管理员撤销置顶帖子
     */
    const val APP_PATH_UNDO_TOP_POST =
        "api/$API_VERSION_2/plus-group/pinned/posts/{post_id}/cancel"

    /**
     * 帖子申请置顶列表
     */
    const val APP_PATH_TOP_POST_LIST =
        "api/$API_VERSION_2/plus-group/pinned/posts"

    /**
     * 帖子打赏
     */
    const val APP_PATH_REWARD_POST =
        "api/$API_VERSION_2/plus-group/group-posts/{post_id}/new-rewards"

    /**
     * 帖子打赏列表
     */
    const val APP_PATH_GET_REWARD_POST_LIST =
        "api/$API_VERSION_2/plus-group/group-posts/{post_id}/rewards"

    /**
     * 帖子评论置顶
     */
    const val APP_PATH_TOP_POST_COMMENT =
        "api/$API_VERSION_2/plus-group/currency-pinned/comments/{comment_id}"

    /**
     * 帖子评论置顶申请列表
     */
    const val APP_PATH_GET_TOP_POST_COMMENT =
        "api/$API_VERSION_2/plus-group/pinned/comments"

    /**
     * 同意帖子评论置顶
     */
    const val APP_PATH_APPROVED_POST_COMMENT =
        "api/$API_VERSION_2/plus-group/currency-pinned/comments/{comment_id}/accept"

    /**
     * 拒绝帖子评论置顶
     */
    const val APP_PATH_REFUSE_POST_COMMENT =
        "api/$API_VERSION_2/plus-group/currency-pinned/comments/{comment_id}/reject"

    /**
     * 同意帖子置顶
     */
    const val APP_PATH_APPROVED_POST =
        "api/$API_VERSION_2/plus-group/currency-pinned/posts/{post_id}/accept"

    /**
     * 拒绝帖子置顶
     */
    const val APP_PATH_REFUSE_POST =
        "api/$API_VERSION_2/plus-group/currency-pinned/posts/{post_id}/reject"

    /**
     * 圈子成员列表
     */
    const val APP_PATH_GET_CIRCLE_MEMBERS =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/members"

    /**
     * 帖子收藏
     */
    const val APP_PATH_COLLECT_POST_FORMAT =
        "api/$API_VERSION_2/plus-group/group-posts/%s/collections"
    const val APP_PATH_EXCELLENT_POST_FORMAT =
        "api/$API_VERSION_2/group/posts/%s/toggle-excellent"
    const val APP_PATH_UNCOLLECT_POST_FORMAT =
        "api/$API_VERSION_2/plus-group/group-posts/%s/uncollect"
    const val APP_PATH_COLLECTLIST_POST_FORMAT =
        "api/$API_VERSION_2/plus-group/user-post-collections"

    /**
     * 删除帖子/帖子详情
     */
    const val APP_PATH_POST =
        "api/$API_VERSION_2/plus-group/groups/{circle_id}/posts/{post_id}"
    const val APP_PATH_POST_FORMAT =
        "api/$API_VERSION_2/plus-group/groups/%s/posts/%s"

    /**
     * 删除帖子评论
     */
    const val APP_PATH_DELETE_POST_COMMENT =
        "api/$API_VERSION_2/plus-group/group-posts/{post_id}/comments/{comment_id}"
    const val APP_PATH_DELETE_POST_COMMENT_FORMAT =
        "api/$API_VERSION_2/plus-group/group-posts/%s/comments/%s"

    /**
     * 举报圈子
     */
    const val APP_PATH_CIRCLE_REPOT =
        "api/$API_VERSION_2/plus-group/groups/{group_id}/reports"

    /**
     * 拒绝举报
     */
    const val APP_PATH_REFUSE_CIRCLE_REPOT =
        "api/$API_VERSION_2/plus-group/reports/{report_id}/reject"

    /**
     * 同意举报
     */
    const val APP_PATH_APPROVE_CIRCLE_REPOT =
        "api/$API_VERSION_2/plus-group/reports/{report_id}/accept"

    /**
     * 圈子举报列表
     */
    const val APP_PATH_GET_CIRCLE_REPOTS =
        "api/$API_VERSION_2/plus-group/reports"

    /**
     * 举报圈子中的帖子
     */
    const val APP_PATH_CIRCLE_POST_REPOT =
        "api/$API_VERSION_2/plus-group/reports/posts/{post_id}"

    /**
     * 举报评论
     */
    const val APP_PATH_COMMENT_REPOT =
        "api/$API_VERSION_2/plus-group/reports/comments/{comment_id}"

    /**
     * 组件 目前：动态（feed）、音乐（music）、资讯（news）
     */
    //    public static final String APP_COMPONENT_FEED = "feed";
    const val APP_COMPONENT_MUSIC = "music"

    //    public static final String APP_COMPONENT_NEWS = "news";
    const val APP_COMPONENT_SOURCE_TABLE_MUSIC_SPECIALS = "music_special"

    /**
     * @see{https://github.com/slimkit/thinksns-plus/blob/master/docs/api/v2/user/likes.md}
     */
    const val APP_LIKE_FEED = "feeds"
    const val APP_LIKE_MUSIC = "musics"
    const val APP_LIKE_MUSIC_SPECIALS = "music_specials"
    const val APP_LIKE_NEWS = "news"
    const val APP_LIKE_GROUP_POST = "group-posts"
    const val APP_QUESTIONS = "questions"
    const val APP_QUESTIONS_ANSWER = "question-answers"
    const val APP_LIKE_COMMENTS = "comments" //评论点赞
    /*******************************************  API V2   */
    /**
     * 系统相关
     */
    // 获取启动信息
    const val APP_PATH_GET_BOOTSTRAPERS_INFO =
        "api/$API_VERSION_2/bootstrappers"

    // 获取所有广告
    const val APP_PATH_GET_ADVERT_INFO =
        "api/$API_VERSION_2/advertisingspace"

    // 获取一个广告位的广告列表
    const val APP_PATH_GET_SINGLE_ADVERT_INFO =
        "api/$API_VERSION_2/advertisingspace/{advert_id}/advertising"

    // 获取批量广告位的广告列表
    const val APP_PATH_GET_All_ADVERT_INFO =
        "api/$API_VERSION_2/advertisingspace/advertising"

    // 版本更新
    const val APP_PATH_GET_APP_NEW_VERSION =
        "api/$API_VERSION_2/plus-appversion"

    /*** --------------------------------------广告内部跳转------------------------------------------ */
    const val ADVERT = ".*?"
    val ADVERT_DYNAMIC = APP_DOMAIN + ADVERT + "feeds/(\\d+).*"
    val ADVERT_INFO = APP_DOMAIN + ADVERT + "news/(\\d+).*"
    val ADVERT_CIRCLE = APP_DOMAIN + ADVERT + "groups/(\\d+).*"
    val ADVERT_POST =
        APP_DOMAIN + ADVERT + "groups/(\\d+)/posts/(\\d+).*"
    val ADVERT_QUESTION =
        APP_DOMAIN + ADVERT + "questions/(\\d+).*"
    val ADVERT_ANSWER =
        APP_DOMAIN + ADVERT + "questions/\\d+/answers/(\\d+).*"
    val ADVERT_TOPIC = APP_DOMAIN + ADVERT + "topic/(\\d+).*"
    val ADVERT_QUESTION_TOPIC =
        APP_DOMAIN + "api/" + API_VERSION_2 + "/question-topics/(\\d+)"

    /**
     * 通用 CommonClient
     */
    // 非会员短信 ，用于发送不存在于系统中的用户短信，使用场景如注册等。
    const val APP_PATH_GET_NON_MEMBER_VERTIFYCODE =
        "api/$API_VERSION_2/verifycodes/register"

    // 获取会员短信验证码，使用场景如登陆、找回密码，其他用户行为验证等。
    const val APP_PATH_GET_MEMBER_VERTIFYCODE =
        "api/$API_VERSION_2/verifycodes"
    const val APP_PATH_GET_APP_VERSION =
        "api/$API_VERSION_2/plus-appversion"

    /**
     * 用户相关
     */
    // 获取当前用户
    const val APP_PATH_GET_CURRENT_USER_INFO = "api/$API_VERSION_2/user"

    // 获取指定用户
    const val APP_PATH_GET_SPECIFIED_USER_INFO =
        "api/$API_VERSION_2/users/{user_id}"

    // 批量获取指定用户
    const val APP_PATH_GET_BATCH_SPECIFIED_USER_INFO =
        "api/$API_VERSION_2/users"

    // 热门用户
    const val APP_PATH_GET_HOT_USER_INFO =
        "api/$API_VERSION_2/user/populars"

    // 最新用户
    const val APP_PATH_GET_NEW_USER_INFO =
        "api/$API_VERSION_2/user/latests"

    // 通过 tag 推荐
    const val APP_PATH_GET_RECOMMENT_BY_TAG_USER_INFO =
        "api/$API_VERSION_2/user/find-by-tags"

    // 获取后台推荐用户
    const val APP_PATH_GET_RECOMMENT_USER_INFO =
        "api/$API_VERSION_2/user/recommends"
    const val APP_PATH_SEARCH_RECOMMENT_USER =
        "api/$API_VERSION_2/user/search"

    // 通过 phone 推荐
    const val APP_PATH_GET_BY_PHONE_USER_INFO =
        "api/$API_VERSION_2/user/find-by-phone"

    // 更新用户地址
    const val APP_PATH_UPDATE_USER_LOCATION =
        "api/$API_VERSION_2/around-amap"

    // 根据经纬度查询周围最多50KM内的 TS+ 用户
    const val APP_PATH_GET_USER_AROUND = "api/$API_VERSION_2/around-amap"

    // User Append Follower Count
    const val APP_PATH_USER_APPEND_MESSAGE_COUNT =
        "api/$API_VERSION_2/user/counts"

    // 清空消息未读数
    const val APP_PATH_USER_APPEND_READ_MESSAGE =
        "api/$API_VERSION_2/user/counts"

    // 清理新增关注统计数量
    const val APP_PATH_CKEAR_USER_APPEND_READ_MESSAGE =
        "api/$API_VERSION_2/user/clear-follow-notification"

    // 获取用户黑名单列表
    const val APP_PATH_GET_USER_BLACK_LIST =
        "api/$API_VERSION_2/user/blacks"

    // 把用户加入黑名单
    const val APP_PATH_ADD_USER_TO_BLACK_LIST =
        "api/$API_VERSION_2/user/black/{user_id}"

    // 把用户加入黑名单
    const val APP_PATH_REMOVE_USER_FROM_BLACK_LIST =
        "api/$API_VERSION_2/user/black/{user_id}"

    /**
     * 签到
     */
    // 获取签到信息
    const val APP_PATH_GET_CHECK_IN_INFO =
        "api/$API_VERSION_2/user/checkin"

    // 签到
    const val APP_PATH_CHECK_IN =
        "api/$API_VERSION_2/user/checkin/currency"

    // 连续签到排行榜
    const val APP_PATH_GET_CHECK_IN_RANKS =
        "api/$API_VERSION_2/checkin-ranks"

    /**
     * 举报用户
     */
    const val APP_PATH_REPORT_USER =
        "api/$API_VERSION_2/report/users/{user_id}"

    /**
     * 三方登录绑定
     */
    const val PROVIDER_QQ = "qq"
    const val PROVIDER_WEIBO = "weibo"
    const val PROVIDER_WECHAT = "wechat"

    // 获取已绑定的第三方
    const val APP_PATH_GET_BIND_THIRDS =
        "api/$API_VERSION_2/user/socialite"

    // 检查绑定并获取用户授权
    const val APP_PATH_CHECK_BIND_OR_GET_USER_INFO =
        "api/$API_VERSION_2/socialite/{provider}"

    // 检查注册信息或者注册用户
    const val APP_PATH_CHECK_REGISTER_OR_GET_USER_INFO =
        "api/$API_VERSION_2/socialite/{provider}"

    // 已登录账号绑定
    const val APP_PATH_BIND_WITH_LOGIN =
        "api/$API_VERSION_2/user/socialite/{provider}"

    // 输入账号密码绑定
    const val APP_PATH_BIND_WITH_INPUT =
        "api/$API_VERSION_2/socialite/{provider}"

    // 输取消绑定
    const val APP_PATH_CANDEL_BIND =
        "api/$API_VERSION_2/user/socialite/{provider}"

    // 第三方登录接口 （新写）
    const val APP_PATH_THIRD_LOGIN = "api/$API_VERSION_2/thirdLogin"

    // 第三方注册接口 （新写）
    const val APP_PATH_THIRD_REGISTER = "api/$API_VERSION_2/thirdReg"

    // 第三方分享地址 （新写）
    val APP_PATH_THIRD_SHAREURL =
        H5_PATH_FORMAL + "Home/Thinkdiag/sharePage/product/thinkdiag/client/android/feed/"

    /**
     * 资讯
     */
    // 资讯分类列表
    const val APP_PATH_INFO_TYPE_V2 = "api/$API_VERSION_2/news/cates"
    const val APP_PATH_INFO_LIST_V2 = "api/$API_VERSION_2/news" // 资讯列表
    const val APP_PATH_INFO_TOP_LIST =
        "api/$API_VERSION_2/news/categories/pinneds" // 获取置顶资讯
    const val APP_PATH_INFO_DETAIL =
        "api/$API_VERSION_2/news/{news}" // 详情
    const val APP_PATH_INFO_DETAIL_RELATION =
        "api/$API_VERSION_2/news/{news}/correlations" // 相关资讯
    const val APP_PATH_INFO_DIG_V2 =
        "api/$API_VERSION_2/news/{news}/likes" // 点赞
    const val APP_PATH_INFO_DIG_V2_S =
        "api/$API_VERSION_2/news/%s/likes" // 点赞
    const val APP_PATH_INFO_DIG_LIST =
        "api/$API_VERSION_2/news/{news}/likes" // 点赞列表
    const val APP_PATH_INFO_COLLECTION =
        "api/$API_VERSION_2/news/{news}/collections" // 收藏
    const val APP_PATH_INFO_COLLECTION_S =
        "api/$API_VERSION_2/news/%s/collections" // 收藏
    const val APP_PATH_INFO_COLLECTION_LIST =
        "api/$API_VERSION_2/news/collections" // 获取收藏列表
    const val APP_PATH_INFO_COMMENT_V2 =
        "api/$API_VERSION_2/news/{news}/comments" // 评论
    const val APP_PATH_INFO_COMMENT_V2_S =
        "api/$API_VERSION_2/news/%s/comments" // 评论
    const val APP_PATH_INFO_GET_COMMENT =
        "api/$API_VERSION_2/news/{news}/comments" // 获取评论列表
    const val APP_PATH_INFO_DELETE_COMMENT_V2 =
        "api/$API_VERSION_2 /news/{news}/comments/{comment}" // 删除评论
    const val APP_PATH_INFO_DELETE_COMMENT_V2_S =
        "api/$API_VERSION_2/news/%s/comments/%s" // 删除评论
    const val APP_PATH_INFO_DELETE =
        "api/$API_VERSION_2/news/categories/{category}/news/{news}" // 删除资讯
    const val APP_PATH_INFO_MANAGER_DELETE =
        "api/$API_VERSION_2/news/posts/{id}" // 管理员删除资讯
    const val APP_PATH_INFO_PINNED =
        "api/$API_VERSION_2/news/{news}/pinneds" // 置顶
    const val APP_PATH_INFO_PINNED_S =
        "api/$API_VERSION_2/news/%s/pinneds" // 置顶

    /**
     * 钱包
     */
    // 提现
    const val APP_PAHT_WALLET_WITHDRAW =
        "api/$API_VERSION_2/plus-pay/cashes"

    // 钱包余额充值
    const val APP_PAHT_WALLET_RECHARGE =
        "api/$API_VERSION_2/plus-pay/recharge"

    // 钱包余额充值凭据
    const val APP_PAHT_WALLET_RECHARGE_SUCCESS =
        "api/$API_VERSION_2/plus-pay/orders/{order}"

    // 钱包流水
    const val APP_PAHT_WALLET_RECHARGE_SUCCESS_LIST =
        "api/$API_VERSION_2/plus-pay/orders"

    // 凭据回执
    const val APP_PAHT_WALLET_RECHARGE_SUCCESS_CALLBACK =
        "api/$API_VERSION_2/wallet/charges/{charge}?mode=retrieve"
    const val APP_PAHT_WALLET_RECHARGE_SUCCESS_CALLBACK_FORMAT =
        "api/$API_VERSION_2/wallet/charges/%s?mode=retrieve"

    //    钱包余额转积分
    const val APP_PAHT_WALLET_BALANCE_TO_INTEGRATION =
        "api/$API_VERSION_2/plus-pay/transform"

    // 支付宝充值
    const val APP_PAHT_WALLET_RECHARGE_V2 =
        "api/$API_VERSION_2/walletRecharge/orders"

    // 余额充值验证
    const val APP_PAHT_WALLET_VERIFY_V2 =
        "api/$API_VERSION_2/walletRecharge/checkOrders"

    // 积分充值验证
    const val APP_PAHT_INTEGRATION_VERIFY_V2 =
        "api/$API_VERSION_2/currencyRecharge/checkOrders"

    /**
     * 积分
     */
    // 积分配置信息
    const val APP_PAHT_INTEGRATION_CONFIG = "api/$API_VERSION_2/currency"
    const val APP_PAHT_INTEGRATION_RECHARGE =
        "api/$API_VERSION_2/currency/recharge"
    const val APP_PAHT_INTEGRATION_RECHARGE_V2 =
        "api/$API_VERSION_2/currencyRecharge/orders"
    const val APP_PAHT_INTEGRATION_RECHARGE_SUCCESS =
        "api/$API_VERSION_2/currency/orders/{order}"

    // 凭据回执
    const val APP_PAHT_INTEGRATION_RECHARGE_SUCCESS_CALLBACK =
        "api/$API_VERSION_2/currency/webhooks"
    const val APP_PAHT_INTEGRATION_RECHARGE_SUCCESS_CALLBACK_FORMAT =
        "api/$API_VERSION_2/wallet/charges/%s?mode=retrieve"

    // 积分流水
    const val APP_PAHT_INTEGRATION_ORDERS =
        "api/$API_VERSION_2/currency/orders"

    // 积分提取 POST /api/v2/currency/cash
    const val APP_PAHT_INTEGRATION_WITHDRAWALS =
        "api/$API_VERSION_2/currency/cash"

    /*排行榜相关*/ /*用户*/ // 全站粉丝排行榜
    const val APP_PATH_RANK_ALL_FOLLOWER =
        "api/$API_VERSION_2/ranks/followers"

    // 财富达人排行
    const val APP_PATH_RANK_ALL_RICHES =
        "api/$API_VERSION_2/ranks/balance"

    // 收入排行榜
    const val APP_PATH_RANK_INCOME = "api/$API_VERSION_2/ranks/income"

    // 连续签到排行榜
    const val APP_PATH_RANK_CHECK_IN = "api/$API_VERSION_2/checkin-ranks"

    /*用户 end*/ /*问答*/ // 解答排行 type	string	-	筛选类型 day - 日排行 week - 周排行 month - 月排行
    const val APP_PATH_RANK_QUESTION_ANSWER =
        "api/$API_VERSION_2/question-ranks/answers"

    // 问答达人排行
    const val APP_PATH_RANK_QUESTION_LIKES =
        "api/$API_VERSION_2/question-ranks/likes"

    // 社区专家排行
    const val APP_PATH_RANK_QUESTION_EXPERTS =
        "api/$API_VERSION_2/question-ranks/experts"

    /*问答 end*/ /*动态*/ // 动态排行
    const val APP_PATH_RANK_FEEDS = "api/$API_VERSION_2/feeds/ranks"

    /*动态 end*/ /*资讯*/ // 资讯排行
    const val APP_PATH_RANK_NEWS = "api/$API_VERSION_2/news/ranks"
    /*资讯 end*/
    /************************************* 诊断报告相关  */ // 获取诊断报告
    const val APP_PATH_REPORT = "api/$API_VERSION_2/user/reportList"

    // 上传诊断报告
    const val APP_PATH_UPLOAD_REPORT =
        "api/$API_VERSION_2/user/reportStore"

    // 删除诊断报告
    const val APP_PATH_DELETE_REPORT = "api/$API_VERSION_2/user/delReport"

    /************************************* 诊断的支付和订单  */ //获取产品详情以及积分
    const val APP_PATH_GET_PRODUCTDETAIL =
        "api/$API_VERSION_2/user/getProductDetail"

    //获取支付token （后面又改成了生成订单接口）
    const val APP_PATH_GET_PAYTOKEN = "api/$API_VERSION_2/brainToken"

    //申请结算接口
    const val APP_PATH_BRAINVALIDATE = "api/$API_VERSION_2/brainValidate"

    //支付后，获取订单列表接口
    const val APP_PATH_GETORDERLIST =
        "api/$API_VERSION_2/user/diagOrderList"

    //获取订单详情
    const val APP_PATH_GETORDERINFO =
        "api/$API_VERSION_2/user/getOrderInfo"

    //删除订单
    const val APP_PATH_DELETE_ORDER =
        "api/$API_VERSION_2/user/cancelOrder"
    const val APP_PATH_DELETE_ORDER_TOOL = "/api/v2/user/cancelOrderTool"

    //信用卡支付接口
    const val APP_PATH_AUTHSTART = "api/$API_VERSION_2/authStart"

    //paypal支付接口
    const val APP_PATH_PAYPAL_AUTHORIZECAPTURE =
        "api/$API_VERSION_2/payPalAuthorizeCapture"

    /************************************* 国内软件续费  */ //获取配置软件价格
    const val APP_PATH_GET_CONFIG_PRICE =
        "http://aws.mythinkcar.cn/AdPush/ThinkPlus/getThinkPlusSoftPrice"
    const val APP_PATH_POST_CREATE_CONFIG_ORDER =
        "http://aws.mythinkcar.cn/AdPush/ThinkPlus/createProConfigOrder"
    const val APP_PATH_POST_START_ALIPAY = "http://tcapi.mythinkcar.cn/api/v2/alipay"
    const val APP_PATH_POST_START_WECHAT = "http://tcapi.mythinkcar.cn/api/v2/weipay"
    const val APP_PATH_POST_START_CHECK = "http://tcapi.mythinkcar.cn/api/v2/checkWeiOrder"
    const val APP_PATH_GET_PAY_STATUS = "http://tcapi.mythinkcar.cn/api/v2/checkWeiOrder"

    /************************************* 我的模块以及一些新个人相关的接口  */ // 获取每日推荐的话题 （发现主页最上面显示）
    const val APP_PATH_GET_DAILY_TOPIC = "/api/$API_VERSION_2/dailyTopic"

    // 获取个人优惠码接口  （分享码界面）
    const val APP_PATH_GET_COUPON = "/api/$API_VERSION_2/user/getCoupon"

    /*************************************管理员相关 */ // 删除评论
    const val APP_PATH_DELETE_COMMENT = "api/$API_VERSION_2/comments/%d"

    // 禁用用户
    const val APP_PATH_DIABLEUSER_FORMAT =
        "api/$API_VERSION_2/system/disabled/%d"

    /**
     * 获取token
     */
    const val APP_PATH_GET_TOKEN = "api/$API_VERSION_2/getToken"

    /**
     * 根据sn和vin查询车辆是否支持 和 支持的过期时间
     */
    const val APP_PATH_CHECK_ORDER = "api/$API_VERSION_2/checkOrder"

    /**
     * 获取远程诊断开始的验证码
     */
    const val APP_PATH_REMOTE_CODE =
        "api/$API_VERSION_2/user/makeRemoteCode"

    /**
     * 判断是否是第一次购买
     */
    const val APP_PATH_FRIST_USE_DEVICE = "api/$API_VERSION_2/ifBuyDevice"

    /**
     * 生成订单接口
     */
    const val APP_PATH_MAKE_SALE_ORDER =
        "api/$API_VERSION_2/makeSaleOrder"

    /**
     * 获取文档
     */
    const val APP_PATH_GET_SOFT_DOCUMENT =
        "http://aws.ithinkcar.com/AdPush/Api/getSoftDetailByName"

    /**
     * 获取软件详情
     */
    const val TCAR_GET_SOFT_INFO = "api/v2/user/getProductByPackage"

    /**
     * 获取评论
     */
    const val TCAR_GET_COMMENT_LIST =
        "api/$API_VERSION_2/user/getPointCommentList"

    /**
     * 获取商城广告Banner列表
     */
    const val TCAR_GET_BANNER_LIST = "api/v2/user/getBannerList"

    /**
     * 发送评论
     */
    const val TCAR_SEND_COMMENT = "api/v2/user/pointComment"

    /**
     * 删除评论
     */
    const val TCAR_DELETE_COMMENT = "api/v2/user/delPointComment"

    /**
     * 是否需要评论
     */
    const val TCAR_IS_NEED_COMMENT = "api/v2/user/checkUserComment"

    /**
     * 注册SN
     */
    const val TCAR_REGISTER_SN = "api/v2/user/registerProductForPad"

    /**
     * 获取注册的SN
     */
    const val TCAR_REGISTER_SN_LIST = "api/v2/user/getDeviceList"

    /**
     * 获取商城软件列表
     */
    const val TCAR_SHOP_CAR_LIST = "api/v2/user/getSoftList"

    /**
     * 获取模块购买列表
     */
    const val THINKMODULE_BUY_LIST = "api/v2/user/getPartBySn"

    /**
     * 获取模块配置下发，然后获取USB_ID
     */
    const val THINKMODULE_CONFIG_USBID = "api/v2/user/configDown"

    /**
     * 获取首页硬件列表
     */
    const val TCAR_SHOP_HARD_LIST = "api/v2/user/getHardList"

    /**
     * 获取用户支付积分数目和税费
     */
    const val TCAR_SHOP_GET_POINT = "api/v2/user/getPointTax"

    /**
     * 获取国家
     */
    const val TCAR_SHOP_COUNTRY_LIST = "http://api.mythinkcar.com/Api/Index/countryList"

    /**
     * 获取省洲
     */
    const val TCAR_SHOP_STATE_LIST = "http://api.mythinkcar.com/Api/Index/stateList"
    const val TCAR_SHOP_ADD_ADDRESS = "api/v2/user/addressAdd"
    const val TCAR_SHOP_EDIT_ADDRESS = "api/v2/user/editAddress"
    const val TCAR_SHOP_GET_ADDRESS = "api/v2/user/getAddressList"
    const val TCAR_SHOP_DEL_ADDRESS = "api/v2/user/delAddress"
    const val TCAR_SHOP_DEFAULT_ADDRESS = "api/v2/user/addressSetDefault"
    const val TCAR_SHOP_DEFAULT_PAYDIAG = "api/v2/user/authStartDiag"

    /**
     * 创建订单
     */
    const val TCAR_SHOP_CREATE_ORDER = "api/v2/user/makeDiagOrder"

    /**
     * 商城软件列表
     */
    const val TCAR_SHOP_SOFT_LIST = "api/v2/user/getSoftList"
    const val TCAR_SHOP_SOFT_REGISTER = "api/v2/user/registerProductForPad"

    /*-------------launch--------------*/ //public static final   String APP_LAUNCH_DOMAIN_1 = "https://cntestglbase.x431.com" 1111; "https://usglbase.dbscar.com"
    var APP_LAUNCH_DOMAIN_US =
        "https://usglbase.dbscar.com" // "https://cnglbase.dbscar.com"; // "https://usglbase.dbscar.com";
    const val LAUNCH_DOMAIN_NAME = "US"
    const val H5 = "H5"
    const val LAUNCH_ACTION = "/?action="
    const val LAUNCH_LOGIN = "passport_service.login"
    const val LAUNCH_REGISTER = "passport_service.register"
    const val LAUNCH_SEND_VERIFYCODE = "verifycode.send_code"
    const val LAUNCH_RESET_PWD_VCODE = "passport_service.reset_pass"
    const val LAUNCH_RESET_PASSWORD = "userinfo.set_password"
    const val LAUNCH_APP_VISION = "vision_service.latest"

    //public static final String LAUNCH_APP_UPDATE="https://usglbase.dbscar.com/?action=vision_service.latest&vision_no=0&language=en&is_test=0&app_id=11220";
    //tool 中的商家信息
    const val TOOL_SHOPINFO_UPDATE =
        "api/$API_VERSION_2/user/merchantUpdate"
    const val TOOL_SHOPINFO_GET = "api/$API_VERSION_2/user/merchantInfo"

    //tool 中的客户信息
    const val TOOL_CUSTOMER_GET = "api/$API_VERSION_2/user/customList"
    const val TOOL_CUSTOMER_ADD = "api/$API_VERSION_2/user/customAdd"
    const val TOOL_CUSTOMER_DEL = "api/$API_VERSION_2/user/customDel"
    const val TOOL_CUSTOMER_UPDATE =
        "api/$API_VERSION_2/user/customUpdate"

    /**
     * tool 获取广告接口
     */
    const val TOOL_SCREEN_AD = "http://ad.ithinkcar.com/ad/index/index/"

    /**
     * tool
     * 版本更新
     * 测试服务在getToolApkListTest
     */
    const val TOOL_APP_UPDATE = "api/$API_VERSION_2/user/getToolApkList"

    /**
     * 绑定diag
     */
    const val TOOL_BIND_DIAG =
        "http://uszdmycar.x431.com/rest/syscode/burnTtoolAndTdiag.json"

    /**
     * 同步数据
     */
    const val TOOL_SYN_DIAG =
        "http://uszdmycar.x431.com/rest/syscode/synTtoolAndTdiag.json"
    const val TOOL_REPAIR_VIDEOLIST = "Api/ThinkTool/getVideoList"
    const val TOOL_GET_DEVICE_DETAIL = "api/v2/user/getToolParts"

    /**
     * 查询是否全配置
     */
    const val TOOL_GET_SN_CONFIG = "/api/v2/user/getProConfigBySerialNo"

    /**
     * 全配置下单
     */
    const val CREATE_ORDER_ALL_CONFIG = "/api/v2/user/createProConfigOrder"

    //海外元征上传商家信息
    const val TOOL_SHOP_INFO_EX = "http://aitus.golo365.com/Home/HttApi/addRepairShopNew"

    //国内元征上传商家信息
    const val TOOL_SHOP_INFO_CN = "http://ait.golo365.com/Home/HttApi/addRepairShopNew"

    /**
     * 获取积分
     */
    const val CONFIG_USER_POINT = "/api/v2/user/getUserPoint"
    const val GET_ORDER_DETAIL = "/api/v2/user/getToolOrderInfo"
    const val CHECK_TPMS = "/api/v2/user/checkTpmsBySn"
    val SHARE_REPORT = AWS_THINKCAR + "Home/Index/shareReport/"

    /************************************* 埋点统计接口  */
    const val APP_PATH_STATISTICAL =
        "api/$API_VERSION_2/user/statisticalLog"

    fun getReportUrl(isCn: Boolean): String {
        return if (isCn) {
            "http://aws.mythinkcar.cn/Home/Index/shareReport/"
        } else "http://aws.ithinkcar.com/Home/Index/shareReport/"
    }

    /**
     * FileName: ApiConfig
     * Description:     将几个项目通用的H5地址配置起来，方便定制
     * Author: liubo
     * Date: 2019/10/23   14:07
     */
    object H5ApiConfig {
        const val REWARDSPOINT =
            "https://h5.mythinkcar.com/integral?logintype=androidapp&em=ThinkTool"

        /**
         * Rewards  活动页面链接要带参数    https://mythinkcar.com/home/index/appRewards/uname/用户名/rcode/优惠码/himg/用户头像/client/android或ios
         */
        val REWARDS =
            H5_PATH_FORMAL + "home/Thinktool/appRewards/client/android/uname/"

        /**
         * 帮助
         */
        val FAQ =
            H5_PATH_FORMAL + "home/Thinktool/support/sid/1/client/android/lang/"

        /**
         * 隐私条款
         */
        val PRIVACY_POLICY =
            H5_PATH_FORMAL + "home/index/thinkcarPrivacy/lang/"

        /**
         * 服务条款
         */
        val SERVICE_AGREEMENT =
            H5_PATH_FORMAL + "home/index/thinkcarService/lang/"

        /**
         * 激活弹框点击购买按钮，跳转到Thinkdiag官网详情页面
         */
        val PRODUCTS_BUY_THINKDIAG =
            H5_PATH_FORMAL + "home/index/products_summary/goodsid/3"
    }
}
package enumInterface;

public interface CommonConstant {

    /**
     * ����״̬
     */
    public static final Integer STATUS_NORMAL = 0;

    /**
     * ����״̬
     */
    public static final Integer STATUS_DISABLE = -1;

    /**
     * ɾ����־
     */
    public static final Integer DEL_FLAG_1 = 1;

    /**
     * δɾ��
     */
    public static final Integer DEL_FLAG_0 = 0;

    /**
     * ϵͳ��־���ͣ� ��¼
     */
    public static final int LOG_TYPE_1 = 1;

    /**
     * ϵͳ��־���ͣ� ����
     */
    public static final int LOG_TYPE_2 = 2;

    /**
     * ������־���ͣ� ��ѯ
     */
    public static final int OPERATE_TYPE_1 = 1;

    /**
     * ������־���ͣ� ���
     */
    public static final int OPERATE_TYPE_2 = 2;

    /**
     * ������־���ͣ� ����
     */
    public static final int OPERATE_TYPE_3 = 3;

    /**
     * ������־���ͣ� ɾ��
     */
    public static final int OPERATE_TYPE_4 = 4;

    /**
     * ������־���ͣ� ����
     */
    public static final int OPERATE_TYPE_5 = 5;

    /**
     * ������־���ͣ� ����
     */
    public static final int OPERATE_TYPE_6 = 6;


    /** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_OK_200 = 200;

    /**����Ȩ����֤δͨ�� 510*/
    public static final Integer SC_JEECG_NO_AUTHZ=510;

    /** ��¼�û�ӵ�н�ɫ����KEYǰ׺ */
    public static String LOGIN_USER_CACHERULES_ROLE = "loginUser_cacheRules::Roles_";
    /** ��¼�û�ӵ��Ȩ�޻���KEYǰ׺ */
    public static String LOGIN_USER_CACHERULES_PERMISSION  = "loginUser_cacheRules::Permissions_";
    /** ��¼�û����ƻ���KEYǰ׺ */
    public static final int  TOKEN_EXPIRE_TIME  = 3600; //3600�뼴��һСʱ

    public static final String PREFIX_USER_TOKEN  = "PREFIX_USER_TOKEN_";

    /**
     *  0��һ���˵�
     */
    public static final Integer MENU_TYPE_0  = 0;
    /**
     *  1���Ӳ˵�
     */
    public static final Integer MENU_TYPE_1  = 1;
    /**
     *  2����ťȨ��
     */
    public static final Integer MENU_TYPE_2  = 2;

    /**ͨ��������ͣ�USER:ָ���û���ALL:ȫ���û���*/
    public static final String MSG_TYPE_UESR  = "USER";
    public static final String MSG_TYPE_ALL  = "ALL";

    /**����״̬��0δ������1�ѷ�����2�ѳ�����*/
    public static final String NO_SEND  = "0";
    public static final String HAS_SEND  = "1";
    public static final String HAS_CANCLE  = "2";

    /**�Ķ�״̬��0δ����1�Ѷ���*/
    public static final String HAS_READ_FLAG  = "1";
    public static final String NO_READ_FLAG  = "0";

    /**���ȼ���L�ͣ�M�У�H�ߣ�*/
    public static final String PRIORITY_L  = "L";
    public static final String PRIORITY_M  = "M";
    public static final String PRIORITY_H  = "H";

    /**
     * ����ģ�巽ʽ  0 .��¼ģ�塢1.ע��ģ�塢2.��������ģ��
     */
    public static final String SMS_TPL_TYPE_0  = "0";
    public static final String SMS_TPL_TYPE_1  = "1";
    public static final String SMS_TPL_TYPE_2  = "2";

    /**
     * ״̬(0��Ч1��Ч)
     */
    public static final String STATUS_0 = "0";
    public static final String STATUS_1 = "1";

    /**
     * ͬ������������1ͬ��0��ͬ��
     */
    public static final String ACT_SYNC_0 = "0";
    public static final String ACT_SYNC_1 = "1";

    /**
     * ��Ϣ����1:֪ͨ����2:ϵͳ��Ϣ
     */
    public static final String MSG_CATEGORY_1 = "1";
    public static final String MSG_CATEGORY_2 = "2";

    /**
     * �Ƿ����ò˵�������Ȩ�� 1��0��
     */
    public static final Integer RULE_FLAG_0 = 0;
    public static final Integer RULE_FLAG_1 = 1;

    /**
     * �Ƿ��û��ѱ����� 1(�ⶳ)���� 2����
     */
    public static final Integer USER_UNFREEZE = 1;
    public static final Integer USER_FREEZE = 2;

    /**�ֵ䷭���ı���׺*/
    public static final String DICT_TEXT_SUFFIX = "_dictText";
}

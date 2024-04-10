package com.zhang.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

//常量类
@Component
public class Constant {
    //文件路径
    public static final String IMG_PATH = "src/main/resources/static/images/";
    //超级管理员json
    public static final String MENU0 = "{\n" +
            "  \"homeInfo\": {\n" +
            "    \"title\": \"首页\",\n" +
            "    \"href\": \"page/announcement.html?t=1\"\n" +
            "  },\n" +
            "  \"logoInfo\": {\n" +
            "    \"title\": \"报修平台\",\n" +
            "    \"image\": \"images/logo.png\",\n" +
            "    \"href\": \"\"\n" +
            "  },\n" +
            "  \"menuInfo\": [\n" +
            "    {\n" +
            "      \"title\": \"我的\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"公告\",\n" +
            "          \"href\": \"page/announcement.html\",\n" +
            "          \"icon\": \"fa fa-window-maximize\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"宿舍报修\",\n" +
            "          \"href\": \"\",\n" +
            "          \"icon\": \"fa fa-home\",\n" +
            "          \"target\": \"_self\",\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"title\": \"申请报修\",\n" +
            "              \"href\": \"page/student/request.html\",\n" +
            "              \"icon\": \"fa fa-telegram\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"我的申请\",\n" +
            "              \"href\": \"page/student/myForms.html\",\n" +
            "              \"icon\": \"fa fa-list\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"用户查询\",\n" +
            "              \"href\": \"page/student/studentList.html\",\n" +
            "              \"icon\": \"fa fa-child\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"报修概况\",\n" +
            "              \"href\": \"page/student/statistics.html\",\n" +
            "              \"icon\": \"fa fa-tachometer\",\n" +
            "              \"target\": \"_self\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"维修管理\",\n" +
            "          \"href\": \"\",\n" +
            "          \"icon\": \"fa fa-github-alt\",\n" +
            "          \"target\": \"_self\",\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"title\": \"维修接单\",\n" +
            "              \"href\": \"page/worker/request.html\",\n" +
            "              \"icon\": \"fa fa-hand-pointer-o\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"我的接单\",\n" +
            "              \"href\": \"page/worker/myForms.html\",\n" +
            "              \"icon\": \"fa fa-user\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"我的评价\",\n" +
            "              \"href\": \"page/worker/appraise.html\",\n" +
            "              \"icon\": \"fa fa-comment-o\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"维修概况\",\n" +
            "              \"href\": \"page/worker/statistics.html\",\n" +
            "              \"icon\": \"fa fa-bar-chart\",\n" +
            "              \"target\": \"_self\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"系统管理\",\n" +
            "          \"href\": \"\",\n" +
            "          \"icon\": \"fa fa-user-md\",\n" +
            "          \"target\": \"_self\",\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"title\": \"学生管理\",\n" +
            "              \"href\": \"page/admin/student/studentSetting.html\",\n" +
            "              \"icon\": \"fa fa-child\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"工程师管理\",\n" +
            "              \"href\": \"page/admin/worker/workerSetting.html\",\n" +
            "              \"icon\": \"fa fa-asterisk\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"订单管理\",\n" +
            "              \"href\": \"page/admin/forms/formSetting.html\",\n" +
            "              \"icon\": \"fa fa-tasks\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"分类管理\",\n" +
            "              \"href\": \"page/admin/classify/classifySetting.html\",\n" +
            "              \"icon\": \"fa fa-tags\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"公告管理\",\n" +
            "              \"href\": \"page/admin/billboard/billboardSetting.html\",\n" +
            "              \"icon\": \"fa fa-university\",\n" +
            "              \"target\": \"_self\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"宿舍维修概况\",\n" +
            "          \"href\": \"../page/statistics.html\",\n" +
            "          \"icon\": \"fa fa-bar-chart\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"关于\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"关于作者\",\n" +
            "          \"href\": \"page/adminInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-address-card-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"关于系统\",\n" +
            "          \"href\": \"page/webInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-paper-plane-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    //学生json
    public static final String MENU1 = "{\n" +
            "  \"homeInfo\": {\n" +
            "    \"title\": \"首页\",\n" +
            "    \"href\": \"page/announcement.html?t=1\"\n" +
            "  },\n" +
            "  \"logoInfo\": {\n" +
            "    \"title\": \"报修平台\",\n" +
            "    \"image\": \"images/logo.png\",\n" +
            "    \"href\": \"\"\n" +
            "  },\n" +
            "  \"menuInfo\": [\n" +
            "    {\n" +
            "      \"title\": \"我的\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"公告\",\n" +
            "          \"href\": \"page/announcement.html\",\n" +
            "          \"icon\": \"fa fa-window-maximize\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"宿舍报修\",\n" +
            "          \"href\": \"\",\n" +
            "          \"icon\": \"fa fa-home\",\n" +
            "          \"target\": \"_self\",\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"title\": \"申请报修\",\n" +
            "              \"href\": \"page/student/request.html\",\n" +
            "              \"icon\": \"fa fa-telegram\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"我的申请\",\n" +
            "              \"href\": \"page/student/myForms.html\",\n" +
            "              \"icon\": \"fa fa-list\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"报修概况\",\n" +
            "              \"href\": \"page/student/statistics.html\",\n" +
            "              \"icon\": \"fa fa-tachometer\",\n" +
            "              \"target\": \"_self\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"宿舍维修概况\",\n" +
            "          \"href\": \"../page/statistics.html\",\n" +
            "          \"icon\": \"fa fa-bar-chart\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"关于\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"关于作者\",\n" +
            "          \"href\": \"page/adminInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-address-card-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"关于系统\",\n" +
            "          \"href\": \"page/webInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-paper-plane-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    //工作人员json
    public static final String MENU2 = "{\n" +
            "  \"homeInfo\": {\n" +
            "    \"title\": \"首页\",\n" +
            "    \"href\": \"page/announcement.html?t=1\"\n" +
            "  },\n" +
            "  \"logoInfo\": {\n" +
            "    \"title\": \"报修平台\",\n" +
            "    \"image\": \"images/logo.png\",\n" +
            "    \"href\": \"\"\n" +
            "  },\n" +
            "  \"menuInfo\": [\n" +
            "    {\n" +
            "      \"title\": \"我的\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"公告\",\n" +
            "          \"href\": \"page/announcement.html\",\n" +
            "          \"icon\": \"fa fa-window-maximize\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"维修管理\",\n" +
            "          \"href\": \"\",\n" +
            "          \"icon\": \"fa fa-github-alt\",\n" +
            "          \"target\": \"_self\",\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"title\": \"维修接单\",\n" +
            "              \"href\": \"page/worker/request.html\",\n" +
            "              \"icon\": \"fa fa-hand-pointer-o\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"我的接单\",\n" +
            "              \"href\": \"page/worker/myForms.html\",\n" +
            "              \"icon\": \"fa fa-user\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"我的评价\",\n" +
            "              \"href\": \"page/worker/appraise.html\",\n" +
            "              \"icon\": \"fa fa-comment-o\",\n" +
            "              \"target\": \"_self\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"title\": \"维修概况\",\n" +
            "              \"href\": \"page/worker/statistics.html\",\n" +
            "              \"icon\": \"fa fa-bar-chart\",\n" +
            "              \"target\": \"_self\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"宿舍维修概况\",\n" +
            "          \"href\": \"../page/statistics.html\",\n" +
            "          \"icon\": \"fa fa-bar-chart\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"关于\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"关于作者\",\n" +
            "          \"href\": \"page/adminInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-address-card-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"关于系统\",\n" +
            "          \"href\": \"page/webInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-paper-plane-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static final String MENU3 = "{\n" +
            "  \"homeInfo\": {\n" +
            "    \"title\": \"首页\",\n" +
            "    \"href\": \"page/announcement.html?t=1\"\n" +
            "  },\n" +
            "  \"logoInfo\": {\n" +
            "    \"title\": \"报修平台\",\n" +
            "    \"image\": \"images/logo.png\",\n" +
            "    \"href\": \"\"\n" +
            "  },\n" +
            "  \"menuInfo\": [\n" +
            "    {\n" +
            "      \"title\": \"关于\",\n" +
            "      \"icon\": \"fa fa-address-book\",\n" +
            "      \"href\": \"\",\n" +
            "      \"target\": \"_self\",\n" +
            "      \"child\": [\n" +
            "        {\n" +
            "          \"title\": \"关于作者\",\n" +
            "          \"href\": \"page/adminInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-address-card-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"关于系统\",\n" +
            "          \"href\": \"page/webInfo/index.html\",\n" +
            "          \"icon\": \"fa fa-paper-plane-o\",\n" +
            "          \"target\": \"_self\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public Constant() throws IOException {
    }
}

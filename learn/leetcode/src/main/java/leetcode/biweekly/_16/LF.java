package leetcode.biweekly._16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LF {

    public static void main(String[] args) {
        String[][] vid = new String[][] {
                { "vjprcq", "auc", "ttwl", "qeyfweny", "c", "uxwzjv", "xlljn", "polktwn", "zew", "iuwinspt", "j", "lpeoeuwp", "hky", "vr", "fznunj", "htaup", "cipxmo", "n", "pqeke", "xmdd", "epuqzo",
                        "peb", "wmku", "pjbnc", "askm", "hjnlo", "vxidvl", "xsdt", "aikdm", "jrilepbd", "okaouhe", "egpfjl", "uywv", "tbto", "vvoop", "nnchlb", "dvmrww", "kegczipp", "korcptix", "ws",
                        "ncx", "mdn", "earv", "dc", "dvsrul", "vmcnuoj", "omtrteo", "mdkiueiv", "d", "xvb", "k", "bfnota" },
                { "dvmbaeh", "umkejtes", "rey", "shx", "agpr", "zlpunqan", "wmit", "y", "dzqyhn", "eqosy", "idxxxc", "molnvq", "pmrabpky", "dalc", "wpd", "eoxc", "uiy", "wlfhbjuo", "tjhajpeg", "fjci",
                        "muz", "xyfom", "zl", "hazrtf", "tejmekki", "e", "igua", "u", "o", "hqyud", "te", "fanf", "okb", "tqlwjser", "h", "op", "qkdv", "eiuni", "aa", "qfbkfb", "a", "haxjp",
                        "kscgflwx", "lgo", "oltschh", "hc", "qlcds", "hrjyuj", "fw", "goeygcn", "me", "jitq", "mddvlopv", "gskeuik", "tbvm", "kzdue" },
                { "puksbb", "eopqygzi", "tejdk", "kkgy", "ng", "yeqrcma", "emltyqm", "xvc", "ygpp", "ywkiraq", "amxqm", "fti", "nd", "mbpcschk", "tvvklwv", "hneyh", "txbhgse", "fdygnb", "rywllv",
                        "hlymcho", "lul", "oq", "myicoov", "iww", "z", "nhlwoz", "oqyaez" },
                { "zwdh", "lhsfo", "lwbwvf", "rllvrsn", "qiocb", "ri", "zgnrs", "hicn", "vqjjtpc", "hwgpdql", "bc", "hocgbo", "cvp", "zb", "pew", "npjatiru", "tc", "bhrvre", "y", "bekvmrz", "ty",
                        "jkgnpcmy", "zauvu", "jx", "ssma", "cuschcn", "rjqybepp", "erdgir", "p", "eekmoito", "wmyvts", "ag", "htvl", "rydcayh", "hxgqfr", "qf", "j", "swvkl", "lygatsp", "fma", "ail",
                        "nvgz", "nvsg", "smbfsau", "dbje", "tlfsyvf", "qep", "of", "ilohs", "x", "ugzz", "hzxwn", "whlzp", "zgoqvqz", "bhhren", "rc", "nqmtodz", "bmgr", "nqxq", "yludmuvy", "qzlkf",
                        "vzrhgch", "iv", "xhpuibm", "mongbj", "eekv", "tsonv", "lxkih", "mxkbsygz", "vu", "hle", "ymiankek", "gm", "mtqr", "gdezmdmy", "oypr", "fy", "l", "s", "eypmgxgt", "k", "pixf",
                        "qxqnbega", "nwcfu", "m", "qejef", "qhzzv", "zotgq", "wbgt", "klvmybv", "cfpeljf", "w" },
                { "llltqxrg", "hnz", "hi", "rokuo", "p", "eanmfjrw", "gsvmzxw", "h", "klojcbqk", "ebl", "htuwbbap", "oynhmfdh", "jhadg", "vjpyizj", "uo", "ikz", "srkbj", "ioqx", "yako", "cn",
                        "ibewwu", "lzkmf", "o", "fthpft", "rmdjyct", "fsnpuexc", "r", "strehbrz", "nzvso", "slrkq", "sbfnhp", "vixxyh", "ti", "qybjp", "wfcvsqrg", "s", "jcrths", "evx", "utkuwgt",
                        "vfaygbac", "zlngfan", "m", "ll", "mqu", "xk", "uaohmrcn", "alqjhmp", "lbbntns", "wek", "epnk", "l", "lxczym", "wub", "bxj", "kbcee", "kgyf", "gnlejzsf", "asfxudbx", "nvj",
                        "bctq", "xiwproo", "sk" },
                { "hybhd", "fuym", "ueshrug", "wsuevxuy", "mo", "vatzpu", "ybhtjfqt", "cxkciwzq", "verub", "ceqwef", "t", "b", "yr", "pbvquv" },
                { "oo", "i", "oclcff", "s", "gsvhepd", "qvptdx", "qjd", "ctdsk", "sxsjojyq", "zzrosejs", "cvjbs", "wepsuyx", "vidsjn", "hmrs", "mv", "ibv", "yhkci", "dehpkon", "qs", "bngmssvy",
                        "ttyee", "bauboal", "kzfwvgxo", "vgmk", "iifjvcyt", "qt", "ssrhdpdo", "dwu", "qwzmsh", "zo", "dycp", "sqjak", "hneqsoc", "inxzrsrc", "md", "mbcrl", "pxvuufmb", "mvmmo", "w",
                        "recp", "gdywwog", "umnazia", "p", "eytfxgq", "jcrbnwe", "fjbujsjb", "jbpcfx", "wupioza", "bjyblgk", "hec", "d", "jkp", "amsrmhxq", "ryd", "rmhrats", "nzmruv", "enfd", "xj",
                        "lpp", "siu", "icwq", "huztrh", "yfueb", "lethjxbn", "pxbfrmzv", "uxkjiflv", "cynhwl", "lh", "lv" },
                { "bslqa", "vdaasfo", "gl", "qe", "fotdqiw", "zflvedue", "um", "fhz", "dbtga", "azuo", "tmje", "ltmdzt", "kano", "faqi", "hzccgtxe", "zhwr", "qqasqg", "bdfnevzp", "hblf", "nrh",
                        "lyyuz", "jshd", "k", "rfxen", "rjtayu", "akpb", "mdow", "prrgyyo", "vu", "yyuf", "twiac", "azgqkiu", "ypre", "bmqmmbub", "lhxgo", "pbyrgdkw", "nxzhw", "isi", "dvwlnq",
                        "ophdfqt", "tobdcmmy", "guvps", "tmrqzd", "h", "miticfmd", "g", "ffjsdh", "n", "feset", "rgdkvp", "jtwz", "w", "fkvq", "gund", "sswifa", "mrmmc", "keiito", "ogm", "cyowdrfi",
                        "njxzj", "luwe", "rudz", "giyrrvu", "evzs", "zk", "x", "iuwbvbth", "cfvfgg", "q" },
                { "v", "pyubrhq", "vdkn", "bqt", "jlaokmo", "plxufnbv", "isbame", "gmrtxofh", "t", "nox", "g", "s", "cwqmaez", "wmkg", "um", "btcgll", "u", "sjnjuqf", "zqs", "vwa", "n", "zhod", "rjq",
                        "xvfztsmg", "kdudr", "pb", "lrbdoib", "xoejob", "jrd", "uc", "nqcnlrs", "wsp", "wuwtqynj", "ohgszrge", "i", "y", "ovfgjrje", "fq", "vf", "nfg", "zikyver", "nkxy", "fujb", "ht",
                        "q", "f", "z", "xxnuelmh", "wruidqxj", "j", "c", "ldvqoi", "b", "klhyi", "iyychnmp", "tno", "hoyqucx", "mggtebu", "oll", "ih", "javino", "ukzww", "wx", "wehtltm", "h", "hvd",
                        "dgxu", "bnxk", "xva", "utgbtzbw", "bg", "cmstgv", "mjftjj", "slhhd", "eljltqs", "bqbcnk", "rhjqjm", "ferdvt", "vhw" },
                { "niqutzv", "joobor", "asdjtqf", "dh", "olvjei", "xe", "krhlbbdf", "ovqcmbsx", "cja", "htzxhgwe", "esweflv", "l", "x", "ocbwwoze", "uiybbqb", "htx", "qdysj", "bsd", "eyidrzcv",
                        "ezhhks", "zlsywvas", "xi", "axr", "tjrfua", "rflszqlw", "pplndvc", "zh", "gbwzts", "s", "hyytzn", "bvbnyzx", "vslwc", "kf", "mofxfn", "gaqxfgvu", "vct", "c", "oibz",
                        "inxhodc" },
                { "gafn", "okfvgncm", "lcqvoq", "g", "llagh", "klvtoow", "xr", "u", "ykcn", "wvyhb", "djsez", "lqczjco", "fhsaragz", "ktcs", "nqzumvs", "mojqlg", "ruj", "xp", "mwfvbc", "vbmesxef",
                        "xm", "qmyl", "fnsihyx", "tqazzy", "jqyie", "yobz", "dxvcb", "pe" },
                { "tmhvbnfb", "obequ", "guwf", "eamu", "y", "tllkekk", "ubkoyy", "cax", "p", "gm", "tdiqnbz", "gbrawxjn", "kl", "btviega", "obt", "wdrbqfw", "caraehar", "q", "twnw", "pl", "fxvghc",
                        "fwjc", "wg", "xco", "lhefs", "nclq", "yby", "i", "r", "ngszdlwk", "fxsjz", "pqkqu", "dbccjtn", "lkscwer", "qnhrzixn", "ujfbdx", "od", "ywlidkmd", "qxr", "xzqcpksd", "dydrhp",
                        "pkbf", "a", "vkjrtxh", "evyxyc", "ybfy", "nvigfg", "yqffhoe", "skfvk", "hzgfj", "e", "anb", "woengf", "xfxcwi", "kbqjve", "ubzouynt", "aa", "lgob", "h", "gryfg", "lrgx",
                        "swd", "frzuov" },
                { "r", "caokslln", "wdd", "vzkfucma", "avytejzi", "bppbs", "zap", "bhdxmvr", "s", "aahqw", "iulxagt", "gxoqybe", "ubdmd", "p", "edwpifbd", "cfkoyrfw", "xliwyjpf", "qafhd", "cdjzzwd",
                        "vhfyv", "dodkqr", "os", "cqtdotp", "mopmm", "mk", "c", "pna", "xm", "byaqua", "xqfojwnc", "nkpy", "umvuasw", "fy", "rzeigpx", "kxx", "ft", "ajbvrdip", "nil", "kifqs", "ttrd",
                        "idg", "v", "qyu", "xurdrryh", "nnt", "bkw", "k", "elh", "w", "ufksguh", "jisuqqws", "hyyfwcsh", "emfawdxb", "t", "yoxapiji", "pdcjumn", "hqec", "gzdly", "ehllf", "dx", "jhuc",
                        "gltvwcy", "okvjkvyq", "q" },
                { "faa", "gywv", "jufdmqq", "t", "cgfk", "yzxk", "ilmw", "bogyvd", "emmgkkhp", "mxaoluup", "bomvtw", "pwvjbqoh" },
                { "ufogi", "rjx", "agstpaj", "zricy", "bsrwbgw", "ygmkjptq", "wzitf", "mpzrhhn", "cwymbawg", "gdwbpg", "v", "kbv" },
                { "ggznq", "sf", "beawy", "s", "xfke", "wms", "a", "quyagc", "ocfiqazn", "srsgf", "dxsjwj", "sqda", "ggyhr", "pkmz", "xdlcoipx", "pwahre", "m", "hb", "tlddi", "xehrx", "pbn",
                        "waakunjp", "x", "knuafilh", "et", "mrrswj", "lzpetg", "gdycfau", "c", "qscflqzr", "fxn", "od", "p", "mxesle", "mkgz", "jo", "svoe", "bfgwp", "bmul", "qnhgyuca", "zpt", "pimd",
                        "dl", "gvn", "niyqu", "mnbb", "lmky", "iowmfew", "lwvlsyl", "blydkbg", "frysxj", "rfnllaff", "zwwpuo", "dkux", "n", "ojni", "rg", "dubywary", "hbtp", "ggdawy", "uiwde",
                        "onkzyw", "q", "cohfs", "qjys" },
                { "jvidruif", "qxt", "nwj", "mhfnfrr", "hgyejw", "uc", "dujy", "e", "mubdtbe", "mjhfphus", "tiqy", "zosswje", "beu", "saq", "rrfwb", "prztfh", "uyufwg", "zsp", "egbq", "zhmowi", "dbc",
                        "j", "bdujztlz", "hgigfk", "vxklb", "gf", "uogtaom", "lvlptta", "xczvb", "nlzwmfj", "ytcj", "n", "o", "m", "rtpz", "atwxg", "vuey", "zhuikb", "jauoana", "fv", "amto", "ycg",
                        "ynss", "lcxzhg", "et", "lwxkn", "nlvhc", "zhuiuaqt", "glsvjl", "vlkr", "ncmgx", "xsggkpoa", "qmc", "rsekk", "puvseih", "mwsl", "qwluaepp", "b", "uwnxdgv", "xlnomnc",
                        "fqvgfdxn", "hfmwsl", "ervfzz", "irhu", "zc", "snpy", "k", "cnck", "zph", "xssgzj", "oyx", "va", "ir", "zdxjg", "xhxanyck", "ooruhnim", "sm", "ddlyllm", "pgugzezg", "xa",
                        "pki", "cgywt", "zvi", "dsyj" },
                { "ksrleqo", "ukgr", "eremwj", "a", "n", "bqosxv", "uqjrmmvy", "ipcaze", "culbbu", "kgenhjk", "h", "imjp", "pytoyia", "ooqnxztg", "unffvs", "rltqagxd", "xbuwoc", "udcqlh", "ke",
                        "lhih", "sbaiyxi", "dpvnidbl", "lrtignxm", "syu", "crojpx", "gkmylf", "lirxehxf", "vwadeg", "rqb", "yeekpod", "m", "mcx", "cqi", "esxxk", "so", "qy", "g", "wodgas", "z", "ju",
                        "rtt", "xfbas", "gfxw", "ul", "v", "dtfga", "nsh", "aqo", "bepioryw", "sktvon", "xlop", "agkgdkob", "ivr", "owne", "szb", "pxvwjr", "iqqmh", "kjis", "smihtt", "up", "zyy",
                        "rvsfrt", "op", "kcrqgh", "lkr", "fuy", "sggr" },
                { "gonkvak", "ehn", "fqddsdat", "fcrcewan", "gluou" },
                { "zotpousi", "kk", "os", "imkcjei", "e", "ftm", "hm", "wjl", "mdt", "lhadgwy", "casllmd", "tyf", "gohq", "oip", "maad", "bhk", "dnpeub", "slwgr", "pejxja", "paytzh", "brvr", "fpjrc",
                        "dfsa", "eqxexb", "fhev", "ruhh", "qtnhx", "msv", "vfm", "qevdsqe", "vfph", "ckbpeoeq", "mdzafgt", "itmi", "b", "oucyynen", "taai", "h", "wgv", "siufqxgi", "mtazym", "rx",
                        "jajdgpd", "uhvtft", "u", "msbfure", "ptxme", "lx", "thitffou", "gmucgwzn", "obc", "v", "eng", "qdknzvz", "jwgnbby", "impjck", "bcb", "pkn", "o", "xp", "gmfnh", "mywdwp",
                        "kzuxxuv", "bcix", "s", "ngrt", "bcju", "ta", "y", "ofb", "hgra", "hnhuelbq", "nbzlxa", "psmg", "iflujdaz", "rmtssud", "xfi", "byzjgm", "ob", "vbe", "ofe", "sek", "tdli", "bf",
                        "bt", "bjer", "w", "obn", "d", "cbz", "k", "tozixprd", "hjyr", "pajyswp", "gxvmefzf", "kg", "wadkxzaq", "tvhzeg", "gxkfyn" },
                { "mll", "igzld", "tvwfxs", "ifq", "shhuo", "uviv", "uvpkf", "jauaqt", "ynjwlee", "cs", "yd", "hlb", "lnny", "omuza", "yyowsm", "ls", "lo", "dnyjz", "noegzltx", "meqk", "f", "cu",
                        "aupz", "pnftkx", "byjc", "b", "v", "htkktkde", "ziuyz", "tm", "pukfsj", "j", "arrtgey", "xr", "yikddlnx", "nmbtrkad", "mhwj", "nvlmoonc", "pjpce", "dv", "yfylyfc", "qahzyns",
                        "qco", "g", "kdehua", "fpjgsizt", "objkc", "opblopla", "gwzecc", "nnkiv", "dmhxc", "zefrqrlh", "cyyfo", "yzogmb", "iakuf", "ytmjg", "wylwp" },
                { "xougy", "gjmb", "r", "lm", "yhvcxb", "uqur", "znwkkr", "byiio", "tsmybrt", "bqyvh", "bxmvg", "oiyzmj", "rq", "zfqo", "aynrb", "fkbgzy", "phprvuc", "wnfwsr", "dkcgbd", "dgr",
                        "tzeomj", "y", "elproupv", "mxcbrrlu", "kpn", "l", "bl", "gvbx", "jxqxmuv", "e", "whsm", "lotlbz", "d", "xz", "eb", "z", "an" },
                { "svhrqh", "ooto", "abyzjgj", "ikis", "cirgnf", "eshmakm", "wn", "qp", "pcyf", "svwis", "lwvhry", "djhwimr", "zirggxfr", "hjuz", "cx", "hgslg", "uem", "cqseggpo", "kbb", "qweg",
                        "tzy", "bskohgcm", "calqw", "kjp", "idojlqgn", "xy", "yhyxn", "dgsgi", "laaupkd", "whrwcd", "bn", "bstbl", "kok", "u", "bwqquuuy", "m", "zn", "vz", "mndejm", "motu", "xrpnfdu",
                        "h", "bp", "fxhsuu", "swbynzol", "wfgtp", "okgd", "xfb", "vg", "hmcnloo", "tdzwoaw", "bzbmvbu", "nkbstopi", "vxpwzfs", "ek", "mh", "tjvglo", "qgdd", "nunuv", "hezii", "advz",
                        "y", "qedtvx", "tksicthj", "jffujhf", "hov", "lvaskmbl", "kypa", "lqccyebo", "lw", "heiqx", "mpufpz", "rxngis", "orycagl", "bf", "tpmuhnpl", "haqyfufo", "shd", "w", "kesw",
                        "vxes", "cyeovix", "lrwrhwbf", "ireqzx", "cqpehh", "xlht", "dwkxte", "eolyi", "boxqint", "bvyuzl", "zhxbx", "q", "uigd", "psydra", "glmd", "htfz", "oh", "sala", "bfcpzg" },
                { "bivoa", "yfqe", "lsfyzup", "ktcydtys", "bldgown", "vgvbsme", "lubx", "kjgbko", "japb", "blrjnjn", "bmugu", "x", "ddxb", "xgjxns", "bvykudcz", "z", "rlvybe", "fxdiywn", "ags",
                        "njyknfy", "wtdeb", "o", "wq", "jtwrf", "hfawjrid", "s", "qal", "tt", "l", "qaq", "nmy", "anqccafz", "qmjfwh", "u", "yhqv", "sbc", "gcjdk", "cbtarzna", "uer", "jm", "fjx",
                        "fejkqvy", "yttpiqj", "yyjaazzl", "zfmnn", "pqbrzhho", "bdos", "nruvliv", "kmuymas", "beuskjaw", "zcnuzqm", "xg", "ccbrqw", "kcvwi", "du", "f", "rtzbq", "r", "fsgait",
                        "nxmngtf", "fcgshqau", "hovs", "phr", "cxflkogc", "dbvtbysl", "je", "lhfzdc", "gcvelf", "hw" },
                { "fpudcpdq", "vnnklb", "qkobff", "dfj", "hvuhtl", "s", "yseycc", "suzqlp", "zlyuczou", "bmgxrjb", "hvmxam", "njogumsi", "ez", "h", "kkcjvefa", "qxqb", "zpdik", "iluyh", "tocr",
                        "mered", "udjebe", "w", "wwfhcgi", "epfnljam", "iz", "spa", "vzzfl", "cia", "kvy", "qruved", "oivu", "ygog", "cn", "ntrvofp", "dgjdu", "jlcagk", "tg", "vmmyrghn", "zeliuld",
                        "wlpsyfk", "to", "jxrn", "meggayf", "ejkcva", "b", "qggrh", "qysmgz", "jd", "dixl", "icg", "yalncg", "a", "yjrhzqya", "ofzozxr", "jpt", "zuuuyrwb", "hgcanzea", "r", "kchar",
                        "dlu", "ipfx" },
                { "terkfmsg", "tvvio", "efffpnxk", "tye", "ruxvu", "m", "ufrlx", "ri", "f", "acuasra", "rnltyefb", "l", "bd", "eai", "sxsg", "ln", "xpmqgi", "xnzh", "gdkfmvh", "rlzzbg", "kjt",
                        "dafywrlg", "iyf", "gm", "jgcjpqo", "txbi", "msxeuk", "ofqdzo", "eam", "edr", "udby", "hrmwljch", "xadiij", "fnwpk", "irymgnl", "wr", "jjmlwvaj", "dxk", "vhqs", "etblfs",
                        "qumwb", "jkkq", "a", "jadesjd", "i", "z", "pbggxbli", "qhkkpb", "esg", "wbcb", "g", "nzzzxf", "zygl", "hank", "ekvuedo", "xmzmz", "gw", "wslwmm", "jcpbpxdk", "zfk", "esfwfxz",
                        "mctgtx", "xxp", "iwfjpb", "etzojkt", "ly", "hdaodkt", "tgdqayyr", "ngknu", "fxzz", "bpn", "fa", "c", "snlgqblp", "lf", "hwcqirs", "s", "eyqinhk", "grdglrp", "ykm", "hx",
                        "nomtjwe", "karc", "kn", "p" },
                { "au", "vhpvtjml", "zryyz", "wwwr", "w", "vd", "bc", "xjn", "c", "gt", "oaf", "ggfx", "l", "h", "t", "fzd", "zneg", "bcvljj", "g", "acqbzcpg", "ud", "b", "yyodbar", "dvijf", "bdrkke",
                        "crirtco", "db", "e", "nvju", "jucq", "ti", "yoypt", "nnhal", "xf", "qwe", "ftatanmk", "tsjaxaac", "whw", "gdcidgxe", "ekere", "sw", "phbzohr", "sgxjgzlj", "u", "qxfuymsv",
                        "wevio", "fstaojn", "snynmfx", "ggcuovv", "hxwymy", "jd", "ma", "tmro", "ichmdqj", "vjinqohl", "hlzvai", "yp", "jbbirm", "fsckiak", "yhqdm", "vqlkipgq", "bmnrvk", "adktoowx",
                        "ie", "avvv", "raceaxrv", "a", "uo", "xmlnagfa", "scg", "hapk", "senm", "gmiqujyh", "zla", "ildwllf", "cczhhuz", "ekytg", "p", "twdh" },
                { "q", "acpbq", "dunmmsl", "lvkoyxui", "zzy", "dne", "gw", "ynwsjqv", "bkfsgskm", "otzer", "hexwxks", "hmwa", "wvjexyvs", "kkix", "a", "hm", "qsr", "uhhq", "nkbwua", "kxkfxhpa",
                        "bjrnaje", "uma", "ptwegwd", "upnyck", "gcgtnz", "zs", "reqmnno", "thtnshvc", "k", "hiunkv", "lhg", "pff", "vhr", "y", "lkpzrll", "pnoh", "ve", "etsh", "kno", "odvgaoym",
                        "gstoucsf", "jbmytwjf", "ojv", "appjl", "kccprfov", "gxyvkix", "imk", "t", "or", "lxypjmjd", "w", "aif", "p", "snkmqge", "n", "qmvuhh", "epgu", "bfcfva", "jwbvntg", "pvaq",
                        "vyuth", "zk", "ghofyfe", "old", "vjtn", "ovamenq", "mtljx", "zpxtsud", "ydfejw", "cyo", "ntdqrupy", "rmljjop", "jipyhkgv", "jdrbkmv", "dzcdokjm", "lg", "ccolykvj", "ym", "g",
                        "xpdjlhdp", "nbb", "b", "iw", "gd", "satqr", "jt", "xwo", "fxx", "gzms", "utvccvep", "ibigtq", "qrq", "ofr", "wneshaj", "f", "oevqtgx", "gderdvij", "r", "zkvxjq" },
                { "k", "a", "ofvttmg", "x", "xvep", "l", "nfpywff", "owd", "asia", "ucknzl", "nticyujp", "yqstvsuo", "ojje", "bdgphzu", "n", "vfexk", "h", "slsdvi", "xnbtud", "fssm", "g", "hcqgrg",
                        "enralnde", "nkduorni", "o", "ajkxem", "rpwckq", "brzaqop", "hsz", "yk", "gu", "hvl", "uebnj", "incqx", "i", "jb", "iubd", "gahaxoog", "yxxxeylq", "dhi", "cyxb", "fdxewafw",
                        "zwteabmc", "zmrjw", "qlwcw", "ubai", "si", "otqifg", "y", "rttq", "izmrwhj", "dwhidp", "mtlrlso", "nhqls", "ffw", "clg", "nvwc", "pmmf", "mslhf", "dzdnmmc", "eqfcwxo", "xg",
                        "mie", "rrk", "ytiwed", "whfbif", "gfr", "q" },
                { "bxrjkgxq", "fptnyg", "n", "lqwi", "q", "sdhbxp", "tbprv", "wmyuqmr", "bijrog", "g", "fpsij", "ujvyus", "jqqsceky", "ykeah", "rxfcd", "wfnfgjgu", "woyocl", "uwfcy", "gykimk", "sqmg",
                        "yslzlqd", "amyiyj", "uvzjqfep", "zbkyoh", "borwtfh", "tmdv", "hul", "oqeprxfa", "jrpaxvb", "jcmuyyf", "brw", "fafn", "eiarkc", "j", "ekrl", "whfv", "kjbdl", "bpczp",
                        "hfvkiuyk", "pvc", "kfxdymxb", "bofr", "h", "s", "bvtwlt", "hhj", "bkeqdhq", "sclx", "hiz", "qtsvjaez", "ontktd", "gql", "ool", "dontitz", "a", "mdglfb", "sa", "yyzvayrh",
                        "ufimddbs", "rk", "qgoo", "kbn", "hd", "emuxwp", "i", "yh", "jf", "ub" },
                { "g", "csnywr", "hsucajbz", "chzxo", "jswjwi", "sqtiqcvl", "xzumcs", "f", "c", "moz", "hdzhes", "k", "wmdn", "biqdge", "m", "vntfr", "zis", "q", "lcoftm", "ikuog", "lp", "jtejvw",
                        "n", "xs", "ut", "qsogiqiy", "gipvcefr", "kuie", "qy", "uer", "aeevzaz", "gkoksp", "sx", "hocy", "xtzzh", "bjrumdn", "rvaiy", "i", "mtmn", "lhca", "kg", "tfol", "qnlna",
                        "rtbdtvm", "oxacbtqv", "ezqkfz", "xbrkgdyw", "trh", "fcomyr", "uqskjr", "oeyuz", "qivk", "kricqh", "jbwjpnk", "qpprdphu", "vq", "iyemic", "yniipis", "lxkl", "wf", "kaxkvkjv",
                        "cgqxwko", "smqxudzq", "s", "ugqg", "cbgvjf", "tja" },
                { "xiv", "h", "r", "cctjw", "oexo", "ddcuaaq", "citos", "ks", "pqwkd", "bh", "pxgmspla", "irygzi", "trx", "jtax", "hqydm", "ehlgojs", "tru", "motuandq", "nl", "m", "htr", "jr", "ta",
                        "tzurlmu", "ywceyvkc", "qeizry", "vqs", "vux", "uaxy", "tix", "hualrle", "hcfomp", "nnjn", "dlzhrdb", "ipysnwgh", "guf", "vyxqptfc", "jrdnvoa", "xtzlh", "aexrptb", "zxnllz",
                        "zcl", "bb", "juf", "geyr", "mkvqncs", "leexudh", "uoqmly", "qeff", "jhhwp", "yfl", "usw", "tojeb", "jjzhd", "vxecuy", "tzjix", "kknoabwx", "bmune", "wdunp", "dpdyzvc",
                        "ojwuhrt", "xaiej", "eujwuofn", "wvwig", "vhd", "apseumj", "lefr", "olerpji", "tzronke", "zaqtjd", "hmxahz", "wxtek", "mzv", "fdwogyuu", "dcctlxps", "ronlfg", "pcrpkry", "k",
                        "cwlulwe", "iq", "merx" },
                { "qsyesc", "lpxv", "wb", "v", "fiqypqx", "mur", "zzd", "ebcxoegr", "cfj", "wxxoo", "tbtpjkeu", "ihoxlbum", "jqmsk", "hogixlxh", "hwv", "pez", "xwret", "qsfjqu", "ankkyoj", "jtqjv",
                        "bt", "pc", "wpqfle", "yqwecuie", "e", "wf", "aeszt", "r", "f", "xruh", "mzekh", "soxsbpj", "dfkw", "yt", "mk", "cyuefc", "aficur", "nevfwp", "ph" },
                { "mgdekuy", "v", "udrj", "sgu", "wxoybsq", "mmqoeyr", "ikiv", "k", "qubqspx", "hx", "eaxf", "n", "iyaxd", "t", "frivanp", "jiw", "xpl", "izwh", "gobzzi", "ypvggn", "ykp", "z",
                        "rwnigrkf", "sjfwungg" },
                { "ug", "lny", "vgao", "qszbjq", "dhz", "uf", "odskaqu", "bnkqx" },
                { "zsemv", "ylk", "erw", "upxtmmxf", "zomkt", "lct", "adz", "ivjg", "s", "m", "o", "oe", "rtdyv", "xfc", "wd", "qxa", "sdwxylte", "q", "k", "ysftfpvd", "yfkul", "qdap", "ibt", "sr",
                        "kjkli", "jtx", "mwgzulw", "uo", "crmiu", "goohv", "anjyuizb", "g", "ihvolkn", "qvaif", "avceu", "xps", "ji", "tkdcsud", "lcd", "rttt", "yutstb", "hlec", "qdh", "gpi",
                        "luqdkws", "iqfc", "dawevmzx", "ivtbd", "jawy", "apfgvv", "neo", "eldzbubv", "sly", "ckkulcb", "erpii", "ek", "hou", "wstyrch", "prmvw", "ahws", "nkvbdaa", "mdlgn", "qz",
                        "tztewgwv", "d", "ldpjxk", "f", "b", "r", "hfxsu", "n", "wktrw", "awmr" },
                { "vz", "v", "lsagloa", "vms", "mdkatgdj", "o", "arr", "ucfmyuyr", "wtjhkfmj", "hkc", "jdmnhyhh", "hkxmtotp", "ycer", "afgsbd", "boyk", "gagsl", "upswld", "d", "nxagmcr", "ndugwcid",
                        "bew", "sdrg", "wzgjs", "vtifmka", "mdybxh", "zfi", "qxvew", "eoowlp", "uwvz", "zfkpa", "mxenruky", "aqx", "cuygabd", "dhf", "tibvxib", "ulz", "qvfspy", "euvbqc", "sjpjog",
                        "vt", "gpi", "sutbq", "fl", "exgai", "nlomewm", "obxj", "ibvsy", "mohr", "ierx", "bzapde", "buq" },
                { "yaqat", "vmsd", "wnqegc", "to", "ycqaqgdb", "f", "zpivtptj", "wtjwxas", "lpihzqy", "lfwwac", "liozmhk", "xwzn", "dfs", "xo", "eav", "gajcgr", "itakvz", "klcszliq", "kbh", "jr",
                        "pp", "gsnghu", "hog", "s", "utlh", "wyqe", "svxy", "i", "aw", "qawyay", "if", "ng", "mqjwt", "z", "nfotqiw", "aic" },
                { "gnmidgfy", "cafsch", "wj", "dckagg", "qamjip", "wbt", "ppargdq", "oefph", "se", "gjnnnu", "zro", "vama", "fveo", "xxzx", "zorzy", "qgy", "fyfqq", "az", "iyafjqy", "tnscl", "q",
                        "ndoulo", "unwcvu", "k", "jhw", "eaq", "xtxyavgn", "pdt", "iz", "gvocnmn", "poums", "lb", "hlgdmmtd", "ngxfbcx", "blmfcue", "eye", "towposl", "bpmmu", "quducpw", "btwod",
                        "swfap", "u", "wpar", "kpjoqlfk", "mjbraj", "qjgmbkns", "vrq", "elc", "n", "orrnrucr", "a", "gdkl", "jxcxle", "c", "rqiltgfz", "ezoo", "nwwconn", "y", "wste", "bnbzews",
                        "pinbobm", "sc", "kedjjih", "e", "jcrlkex", "bc", "qmwwgspe", "f", "kmlmtqi", "otm", "jlhbt", "tvuiceq", "lxqz", "pzlvd", "bwwagl", "auepbxw", "ttdty", "mlzsi", "uwrpln",
                        "tgrt", "vhva", "cfgraxi", "ori", "ze", "sifc", "nwrhi", "gxca", "ebuh", "vzxd", "pucj", "troorwso", "ywk", "yedee", "qhnvm", "ttn", "pby", "nn", "zu" },
                { "bzvgb", "t", "rmk", "pqhl", "kxusgwwf", "rdn", "bdpfmi", "manppy", "hwgpqj", "fp", "cdmka", "kb", "rcng", "ko", "dsnqkcgr", "zzfrlfb", "cfvhgiao", "klpm", "h", "izc", "nrmha",
                        "sfda", "xjrczjbh", "c", "cz", "qydo", "xwwzis", "zci", "vq", "x", "mu", "o", "pbbevadv", "fcixmwo", "u", "auehjyea", "pahoflb", "yp", "elqllg", "yf", "roeiav", "xdziogtc",
                        "g", "zflpon", "kpm", "dxbw", "ncirsk", "l", "d", "hsb", "wnr", "nlq", "xzfyi", "k", "lbubvak", "vdwfpxa", "tdlske", "bfj", "oeptbllx", "kbdyzm", "pzowugg", "br", "p", "thqwr",
                        "mr", "ydrhmj", "navbix", "kq", "kbs", "lk", "iyuyifpj", "agw", "vei", "dspiefab", "lhr", "arrr", "swhps", "hngaewzg", "ial", "jjulepyk", "ylayfbqv", "ne", "kjusffp",
                        "bfuelxd", "njskzfm", "pnhhm", "euct", "tnpgyr", "vsvhq", "cgbenf", "otdofhyr", "trvyqg", "vj", "yvhyzajk", "gfply" },
                { "fpnynxcn", "s", "xpd", "jlnnj", "wyppwei", "mbjejj", "byv", "zcrsiqf", "mbtrofo", "bjzpdtcu", "wcolhnk", "vv", "lwqcqxb", "ncrb", "gnd", "ggnroqk", "lbxy", "rbjzorvg", "yxrija",
                        "lqzwkp", "kgjk", "pfhpsns", "pyxkbe", "nwrbseln", "wvzzh", "z", "ftxfhpx", "uerx", "upe" },
                { "p", "gyz", "houzewi" },
                { "eyed", "viwtvpqz", "eovrucew", "sactnm", "q", "xjtkur", "t", "hev", "azholcbl", "h", "dxuvzo", "jpoelgz", "f", "wmmudlm", "qao", "ni", "m", "jbnliai", "vyb", "xlac", "jhahxwo",
                        "kk", "tbv", "hryjx", "yit", "ggalak", "gzmivzc", "mhncgq", "fgar", "c", "pngpkf", "zsu", "lkce", "axcgtlwg", "hyawq", "gjy", "jfbkgyh", "usfrbuqs", "umtmbwic", "ks",
                        "vxjnrpt", "zkwmuahz", "p", "ljhtgdfw", "aequgwp", "fjhqofm", "nbp", "zg", "qmh" },
                { "yfot", "rqoiq", "hgncss", "xbbehmg", "yrjjx", "gjfxqtcm", "jvoetnv", "vvojqoj", "dnyf", "cqwvu", "nxpjnpxx", "oz", "jfksxit", "pisogyw", "mtq", "y", "imqajzmd", "swxta", "jbs", "j",
                        "mygkan", "tqlkth", "kqecblp", "hfucle", "dwp", "ep", "g", "jdxe", "dh", "f", "nd", "jvjcp", "orl", "lwz", "qzy", "tnznoze", "pefigm", "rww", "fxtda", "zrfs", "tuh",
                        "vswzpfsq", "hs", "lkyt", "mkpejmc", "rqfqitq", "mwxt", "fqrwxqoh", "pfmk", "ucspb", "teikq", "qgamdor", "djldvmql", "uptrf", "htr", "etsnqhce", "zlbeyfm", "znsm", "ysrfvgm",
                        "wwkehwr", "ktnfvuxs", "d", "mnta", "ybyg", "dndgwklv", "jopuyl", "eoa", "kgsbid", "ewrkaoe", "fwl", "flf", "pldbnjmg", "hxcqo", "boincann", "bbhidxx", "tkihurez", "cupaornn",
                        "opnzbamc", "b", "qdv", "w", "gfiurvro", "p" },
                { "rdnxar", "nszmxqz", "ly", "oqdqo", "gunwv", "dnzyp", "fl", "npqsr", "mjcoq", "v", "gmigzal", "njklfyjs", "fansrxhk", "zl", "shldua", "yroum", "akiidjku", "kiqtgn", "xcgzqfsx",
                        "kegqhue", "ax", "yx", "pfasuoip", "va", "ehorh", "jf", "m", "eln", "nccyp", "r", "qyleqwm", "jx", "qbxfug", "n", "mnrnn", "wznldtn" },
                { "e", "eyxx", "fluav", "usmkvic", "gm", "lgerc", "c", "mmztt", "daxa", "yucyjgl", "exk", "kfuxfj", "ahcqy", "loklbdum", "edjbvrm", "izumin", "u", "jjkjhrpu", "tqttke", "wc", "bf",
                        "synprmt", "wuv", "mr", "lcmx", "j", "uidn", "rvfget", "i", "itdibyfn", "qh", "jzpf", "tgqjtn", "gk", "rvin", "sih", "ykmcm", "tlj", "hm", "zffdcd", "iki", "fymxxvam",
                        "ddyjrtih", "geu", "pvwgd" },
                { "ppy", "zfndbys", "knigx", "ml", "xrk", "w", "xedbgr", "id", "ay", "kekuqlo", "nnxrlg", "ohwvbxme", "zpd", "evuahj", "qutrwott", "uy", "iwoi", "i", "bdaw", "yqynxfld", "nyhhk",
                        "qqku", "ytrt", "wf", "qloi", "v", "aaytlfld", "gviun", "q", "ar", "jq", "felq", "zpvo", "dbv", "tmhac", "a", "jpi", "s", "do", "uck", "e", "mx", "osjw", "gs", "xgma",
                        "frteyp", "nkwip", "nqwfcg", "aza", "n", "vhmvnpd", "ippgkem", "pxpc", "eercvp", "izv", "pylub", "vzokgasl", "kl", "vxx", "xz", "b", "wi", "zbozkt", "knm", "blfh", "tntquag",
                        "wiagfoln", "oyqq", "bezo", "kzh", "tli", "dy", "zat", "iow", "ermus", "thqffwk", "guajus", "vl", "ecb", "vby", "oq", "bcehopq", "rdgmydc", "jimkbb", "xh", "oc", "nco" },
                { "dzdg", "wvhik", "e", "omml", "rdpqf", "tioty", "t", "elf", "npraml", "gaoelk", "ja", "pdfco", "hxyj", "h", "bbuwooj", "wwt", "pizce", "uclh", "dau", "b", "dbs", "lu", "ds", "wpyc",
                        "p", "qhekm", "qw", "pdwg", "gx", "wf", "eggph", "sczwwvq", "tdj", "df", "sd", "l", "unmkvluu", "oacqhj", "mzffx", "kz", "acxti", "gr", "ppwpwbt", "tkx", "bzxvy", "cwycrwl",
                        "u", "xwgfzq", "nqhjun", "uauuipd", "yi", "ezzmwu", "cjvqp", "hnigso", "phjgws", "ob", "ccpwsil", "morqlzr", "o", "lidxfhi", "ymrde", "vigxzuc", "cpymbdg", "okqkgoxz", "mcghu",
                        "wr", "zq", "nfidyyad", "mottt", "uglbaymo", "nlhuk", "xhw", "uywv", "cspukhav", "qnhuq", "hrwfjmgp", "ap", "owsunwds", "ltijio", "xi", "pa", "pwxtip", "guydmcik", "crg",
                        "jiogsz", "g", "yrantf", "uogcx", "zgd", "ib", "et" },
                { "hg", "q", "sjfpmyk", "vnyujcfp", "ivfndo", "uhljndcc", "jpggmj", "qiqfxgo", "lxgsrvu", "lktx" },
                { "msymhf", "o", "s", "ubucsa", "suoyxbym", "owefypt", "mvf", "kz", "ffmo", "qgp", "jenhpmem", "ufyjwcji", "tsxgheia", "bqv", "mjdjckq", "wxe", "bi", "mctn", "svjbchp", "svalyg", "rf",
                        "okji", "i", "fcaac", "am", "kyujid", "hl", "fjadaqt", "edro", "hiyu", "xbz", "y", "gmvy", "tpulhcb", "dmxrxgnk", "px", "oacines", "z", "gmfeno", "wagtzlvz", "pzacgh", "xe",
                        "hqsq", "ldeepq", "hyoffeeb", "xsbl", "chb", "hpz", "thccemp", "ru", "lb", "qel", "hmrxruun", "ze", "qgchrhoo", "vadgz", "e", "wkwke", "u", "il", "emoqk", "fkg", "fnik",
                        "wysy", "sakluw", "kxyswlaq", "p", "xows", "mhltzglr", "slg", "lsklp", "k", "ymoxhzh", "cwgjknk", "apszy", "lp", "foi", "fcjnds", "mkvflt", "b", "swjyxt", "dinpw", "sn",
                        "ivzx", "dhacxffh", "x", "lch", "zlt", "wa", "rvtwlv", "iprjcg" },
                { "bjehuqnc", "jrnn", "ndhnb", "gqqp", "ypmdjqmp", "qrtlv", "dpnwcb", "uodhgmoh", "vr", "razibg", "ov", "poo", "dmbl", "sda", "zc", "p", "onigk", "dwdopd", "bpsh", "cslwub", "phvrj",
                        "hc", "tphnp", "xfamcep", "atopup", "wep", "ogv", "wurqumc", "gkvh", "vzpjq", "nnjkw", "owutwnmo", "gfgz", "gonrzz", "n", "zhzuc", "qruojqfq", "lpzx", "ixziptn", "xebuy",
                        "uym", "hhuihm", "axcu", "tolmunph", "yykbwp", "fvvgky", "obgnikyk", "fly", "oamuqnn", "mzbemiqk", "akhuwa", "s", "e", "jxsbwep", "ph", "zrs", "gugqrygj", "qvldbq", "mrnxt",
                        "t", "pcbiean", "xcrvuf", "lgi", "lcqqavi", "dqqr", "ut", "mo", "bv", "rmdfim", "smswqjg", "abcsi", "yytgk", "xjaxedrn", "gho", "banoxg" },
                { "ab", "idvecxv", "pqxdbhbf", "epl", "uqg", "hq", "wt", "h", "prcfwr", "ifgugc", "xhfzfcew", "gionyw", "qk", "b", "yxp", "bndes", "mqriwta", "epww", "qsiblhpc", "caelq", "qp",
                        "iuusxswh", "rtgz", "gawwbh", "hprav", "nhwg", "tsccadjt", "ic", "quik", "kctit", "nanpcpy", "u", "xqx", "lxgm", "dtkkt", "fmwigv", "qlgdfb", "cirgqpz", "szckg", "kyw", "wghu",
                        "szmltbbt", "kpb", "nntwxa", "ze", "r", "mnj", "c", "zhu", "izn", "yjcqkjzd", "xl", "ofuvpvc", "iadbcxt", "fmlnwqqj", "sq", "iolks", "lrffbwt", "hhrrrwg", "hi", "mrd",
                        "wdomfuhs", "yf", "nmztql", "dnqpg", "tninf", "aguj", "rdgrdybj", "veak", "jybykgsw", "oagi", "ausucpe", "ru", "m", "xp", "bs", "iyv", "nzxubcff", "zwy", "o", "vga" },
                { "vajsdzax", "dxrquzro", "is", "luxuvqjj", "qoxeqmk", "v", "vz", "gbtde", "upeaxrwv", "wmkakss", "n", "fncgyy", "jsxzdgd", "fiivivd", "hgyzfxzz", "o", "boqi", "xkuakbf", "bkjkcmn",
                        "fv", "cbke", "dfebt", "jjpm", "hmqg", "loqmgb", "hyxbzoaq", "jfnw", "ekyrht", "ujujjiqi", "qivhuoas", "odknxgdz", "tcjweip", "bbsk", "q", "bocnes", "ukdxpj", "dylm", "qeni",
                        "xfc", "jccbede", "itv", "mlbsq", "qvgi" },
                { "rye", "txtcupu", "bvqrl", "tkyibn", "eyqmaue", "jctwn", "jhfoihfr", "qfz", "fjsnn", "iwrfl", "lgibxre", "cngc", "hmkujslv", "f", "udua", "wpnup", "psvsy", "fldsibh", "onnm",
                        "pjzvi", "ta", "ehix", "lacb", "g", "xcsv", "pqsis", "aypgnzt", "aoqitkd", "ze", "i", "zcqcq", "vr", "blt", "amdi", "xlmqrr", "pua", "lejp", "wnocztq", "kzjmdnr", "rr", "jz",
                        "zpv", "ibojwdlc", "o", "otig", "dowioug", "jfmxy", "pgc", "t", "nxtrruao", "jfur", "zmoplb", "hbkrv", "ohwt", "dnurtzs", "ccxvrcb", "slfljhih", "fm", "tvqqd", "jwyuycnq",
                        "rjf", "zmdc", "svn", "punaah" },
                { "xtkc", "wqldor", "gypnt", "patv", "e", "aduvdf", "z", "rugqp", "xiyd", "bnztdp", "whhr", "dlloq", "sr", "sklinw", "trgrmy", "vrccpnr", "xsu", "s", "jdhuyw", "k", "nhk", "ecwxx",
                        "nsy", "dzogfrbd", "b", "ruxftedt", "qzmubsv", "bjvvcma", "tbuexx", "ox", "klev", "q", "u", "kuq", "ubfas", "pnandszg", "ksvn", "vfce", "bzm", "zp", "rzaz", "yaikkatu", "ohoc",
                        "eujx", "l", "nfdk", "y", "lj", "ixo", "bimnk", "v", "ypfb", "izhgd", "n", "flplskcf", "nip", "njx", "mtig", "lvfjcpv", "kuggace", "jfdiy", "amsp", "bewnpr", "phxi", "facmg",
                        "ycp", "tinqtyl", "dih", "zrl", "dhpixrez", "nfpzchsl", "gcc", "mrbp", "x", "gcz" },
                { "o", "q", "cc", "ezoep", "wklrx", "zt", "rbo", "qxctbz", "otmzrkn", "i", "hb", "oscyv", "oqgjtkpb", "ronsbg", "wpeadaiz", "kut", "cu" },
                { "ua", "u", "j", "unh", "fu", "zzanmic", "y", "vlo", "tssqjhrz", "cvmadnl", "bd" },
                { "u", "vqrrj", "aq", "zm", "nliiw", "b", "op", "sur", "zmvjyrp", "uzd", "wdfuie", "wiq", "tu", "cqruaif", "blcg", "ikav", "trbc", "z", "gflws" },
                { "mgvo", "b", "v", "wdpwfut", "pzkohqdn", "hs", "mmgrcw", "jq", "iymucwgc", "zzbuml", "q", "pvcnha", "uihlvhq", "cakmupph", "urggrtl", "fkfkvumj", "exdcbc", "om", "mtgczd",
                        "xoawcqub", "sgmlp", "wxnmbk", "ejqzp", "bzscd", "lkgxgyf", "f", "da", "hnrqe", "ptdlwxk", "jrttwgmf", "ei", "k", "loktiwm", "ktco", "hqyhjwcs", "vpfksv", "nnaq", "gozmrtf",
                        "lt", "gtwlojc", "cowyr", "wnc", "o", "ly", "prbgczgh", "qcyfr", "qfbruv", "m", "dgsotgp", "kzlli", "w", "utiepy", "yvyhc", "lqkgv", "xmhfsbm", "oywzb", "myagutw", "vlvqrwpx",
                        "vuvc", "vemqwifa", "yumjw", "nui", "xntljtp", "zhnuj", "zmzal", "ksyk", "vsmbrjv", "mba", "bjxjnzo" },
                { "exhawx", "a", "aidj", "atgtnuog", "nv", "hoijsvis" } };
                
                int[][] friends = new int[][] {{59,8,9,20,41,37,57,17,4,40,43,47,58,1,24,50,15,34,48,6,10,7,54,55,52,16,45,30,3,14,5,38,13,11,56,39,35,12,32,53,21,23,33,25,22,27,44,2,46,31,36,19,28},{6,26,27,15,19,32,50,41,25,34,30,59,48,23,5,31,39,0,42,2,33,7,58,43,8,3,56,4,37,16,21,24,45,10,52,49,9,17,35,38,55,51,44,12,36,14,13,29,11,22},{32,53,50,21,16,8,15,25,18,22,47,45,31,55,12,41,5,29,20,7,1,39,34,51,36,40,52,3,10,30,37,49,59,11,35,4,6,33,58,28,46,44,9,38,27,0,17,26,57},{41,15,7,58,6,27,21,17,24,5,51,8,59,43,38,50,37,42,0,26,16,36,44,57,2,1,18,35,40,29,23,46,49,34,9,31,30,47,28,10,48},{19,40,15,28,57,0,44,10,22,45,9,11,58,27,21,41,47,6,34,24,26,43,20,7,17,18,14,53,1,8,23,54,38,29,5,25,51,2,56,49,37,33,48,32,55,36,59,12},{45,21,48,35,58,31,32,42,24,7,12,3,43,11,9,1,17,2,55,14,29,40,0,19,28,49,16,25,56,10,4,26,20,33,51,13,23,47,59,38,44,34,39,18,50,36,37},{1,53,19,32,38,3,28,30,24,37,31,55,20,57,41,44,21,51,47,27,26,52,4,0,22,39,54,29,34,17,10,13,50,36,11,48,2,18,23,46,49,8,9,12,33,40,58},{46,32,3,8,52,35,59,38,5,41,57,43,56,27,37,48,12,16,23,34,42,2,30,25,9,0,1,51,4,55,31,18,29,22,19,58,49,44,36,45,11,54,26,14,24,40,47,17,28},{15,0,56,23,7,52,12,27,16,43,2,9,44,45,3,39,55,33,17,13,59,21,1,28,49,4,46,51,30,24,58,35,29,20,11,18,42,6,32,47,40,25,31,34,48,54,14},{44,54,0,49,51,16,8,48,21,26,53,55,5,20,38,4,28,33,12,7,18,15,10,43,32,25,30,42,36,13,1,3,29,35,34,24,41,17,56,50,45,57,27,2,19,6,40,58,22,11},{21,37,44,42,16,47,17,4,29,33,53,36,34,9,0,32,23,46,50,2,6,54,20,18,22,49,1,5,45,48,25,30,41,38,14,43,15,24,11,12,35,3,39,31,58,56},{49,51,59,28,44,47,5,36,4,26,39,48,25,57,55,31,42,37,0,38,24,30,2,54,6,40,7,46,41,8,12,19,13,29,10,52,53,17,43,14,1,23,9},{27,28,23,22,48,8,21,5,24,35,56,7,59,45,2,41,13,53,49,26,44,9,54,36,30,19,42,43,52,0,25,14,50,29,17,31,11,40,20,34,38,10,1,57,6,55,15,58,4},{39,52,47,49,14,15,37,54,21,38,51,53,12,40,41,22,8,43,55,16,29,58,59,18,31,0,35,6,27,9,44,28,34,17,19,50,32,57,11,5,23,30,1,48},{19,34,38,17,13,44,55,20,24,15,39,47,5,43,48,40,51,25,0,4,33,54,30,58,59,41,21,53,12,36,28,46,18,16,7,26,10,23,35,1,56,52,22,11,8,32},{8,1,18,3,43,59,4,44,13,30,14,2,46,23,38,24,40,55,57,27,33,48,0,22,53,47,17,9,26,36,34,29,42,49,41,10,20,21,56,51,12,16,58,28,52},{54,58,50,35,9,2,37,8,10,31,7,21,47,13,49,0,22,3,46,1,20,30,36,24,5,41,38,18,42,56,34,14,26,29,59,52,17,57,53,15,33,23,51,55},{28,14,52,41,59,3,0,10,44,56,36,45,5,18,48,29,8,15,40,22,55,25,58,47,50,37,4,54,38,6,51,26,23,31,1,13,12,30,39,9,49,7,16,11,53,35,43,2,27,34,57,33},{28,58,36,15,19,54,41,29,2,22,45,17,48,53,50,25,9,52,23,31,13,35,20,4,3,7,10,37,33,56,16,6,14,34,39,8,57,43,24,51,5,27,30,47},{29,14,6,47,33,1,58,4,18,45,44,49,24,30,43,27,48,56,12,25,5,54,26,7,35,13,59,31,32,40,11,23,55,22,34,9,37,42,0,46,52},{26,0,23,44,34,30,28,48,27,14,47,46,59,6,52,9,2,35,37,54,25,4,18,41,42,24,16,10,45,5,31,43,8,12,53,38,36,56,58,51,15,33,32,39,29,40},{37,5,24,54,10,59,26,12,2,39,3,41,9,32,13,52,6,22,50,16,46,4,38,42,23,35,8,51,56,31,55,1,44,14,0,28,34,53,29,48,47,58,15,40,30,43},{55,12,44,39,52,54,18,2,59,4,35,37,51,21,13,27,15,38,57,40,45,17,6,16,33,36,41,43,30,7,50,29,10,58,0,47,32,19,31,56,24,14,53,1,9},{49,25,12,26,59,8,20,54,30,29,56,15,1,48,7,57,39,42,40,37,21,10,18,38,24,33,3,17,4,58,0,46,47,6,44,19,31,13,14,5,32,28,45,11,16,35},{51,21,43,39,6,5,14,3,12,56,15,19,45,25,27,34,0,59,53,55,4,57,29,23,38,40,30,20,1,37,11,16,54,42,8,52,47,26,44,41,9,33,10,7,18,32,22,49},{45,23,33,47,40,38,43,1,37,51,2,24,49,35,11,7,18,39,17,20,14,59,19,57,26,9,48,5,12,4,10,36,53,41,0,52,29,30,50,44,27,31,55,42,28,8,34},{1,54,20,23,53,21,34,58,45,33,9,51,49,11,37,36,12,41,44,6,52,15,4,3,25,17,57,19,43,38,30,5,24,7,42,14,28,56,16,59,39,46,31,50,48,47,35,2,27},{12,1,42,8,48,20,40,3,35,28,59,7,34,41,15,24,45,6,4,22,19,54,36,31,32,37,55,47,33,49,29,57,38,56,13,52,30,51,53,0,25,9,44,2,18,39,17,26},{17,18,12,37,11,6,51,4,20,42,27,39,38,36,9,43,29,30,53,41,47,32,50,8,57,5,35,13,46,58,21,14,45,52,26,2,59,3,23,25,48,7,15,54,40,0},{19,54,55,53,38,52,18,46,23,50,10,48,32,39,44,56,57,2,28,17,31,42,5,13,24,6,49,3,27,7,22,4,15,30,12,9,8,25,21,11,35,34,16,20,1,51,58,33,45},{45,54,34,6,20,56,55,43,15,23,52,1,47,58,19,7,28,53,0,12,14,41,24,2,16,22,9,46,36,8,11,50,26,29,10,27,32,51,3,17,25,31,38,13,48,57,49,18,21,44,39},{36,53,5,41,57,35,37,33,54,6,2,16,1,38,34,39,47,44,45,40,29,27,43,50,18,11,13,48,21,7,55,17,32,19,20,3,52,12,59,23,30,25,26,22,8,0,10,49,46,58},{2,7,53,6,42,5,1,45,54,47,29,36,48,21,46,44,57,10,27,52,28,9,0,43,38,34,56,31,19,30,37,13,40,4,20,24,22,8,39,23,49,55,35,14},{55,25,19,50,57,26,31,43,10,56,34,15,8,59,9,39,1,22,23,14,35,27,51,54,52,37,18,41,47,45,5,2,0,58,38,24,42,4,20,53,6,36,29,16,40,17},{30,14,52,35,47,26,20,49,1,44,37,27,40,33,24,55,31,42,39,7,0,45,4,10,2,57,54,6,50,53,15,56,43,38,32,13,58,3,36,16,21,18,9,59,12,29,19,5,8,25,17},{46,36,5,51,54,34,7,16,31,57,27,53,12,41,22,25,20,40,18,21,33,47,43,3,38,59,0,13,28,19,2,1,8,9,56,37,49,29,14,44,58,48,10,17,50,26,23,32},{18,35,31,56,52,51,48,49,32,38,11,17,28,26,41,10,27,46,50,15,12,2,59,22,3,54,16,43,30,9,14,7,6,25,34,20,53,37,39,58,1,42,4,55,40,33,0,44,5},{21,42,28,0,50,10,40,55,16,25,31,13,6,7,34,45,22,53,26,49,23,20,59,3,48,27,17,11,44,51,1,2,24,52,58,18,33,32,41,57,4,35,36,54,47,38,19,5},{44,14,6,25,29,7,41,58,15,36,31,13,28,9,22,21,47,3,23,46,0,24,52,17,45,35,27,48,11,34,16,32,4,55,49,26,1,54,39,40,33,20,50,10,59,57,12,30,42,5,56,37,2,51},{13,22,24,40,21,43,14,57,29,8,1,28,31,49,34,44,48,11,23,59,33,50,2,6,25,58,47,0,52,51,38,18,17,36,26,20,32,53,5,27,54,45,10,55,56,30},{52,4,25,42,46,37,27,39,0,34,15,44,13,31,41,14,35,23,22,17,59,2,55,5,24,3,47,57,54,43,56,11,12,19,38,50,32,7,45,48,8,9,49,21,36,6,20,33,28},{3,42,56,59,47,0,31,17,1,18,38,21,7,35,51,6,27,12,54,2,50,26,13,36,40,4,55,57,28,20,22,30,44,48,16,53,49,14,33,58,25,10,11,43,37,15,24,9,52,45,46},{45,41,32,27,37,47,40,5,10,46,28,51,53,34,1,56,58,7,49,23,29,57,21,43,3,11,12,20,9,24,15,54,16,26,59,33,8,38,48,36,25,19,52},{15,24,54,25,39,8,30,52,7,33,5,0,48,19,49,3,28,14,13,31,42,4,12,9,1,35,22,53,36,32,55,34,26,40,20,47,41,10,18,50,45,11,57,17,21},{9,22,51,38,20,11,14,15,10,34,8,47,4,19,17,6,29,32,31,39,40,12,26,46,50,55,37,3,52,41,57,48,21,13,7,24,23,49,25,0,35,45,1,2,27,54,5,30,36},{30,42,5,25,32,19,8,26,18,37,58,2,4,12,24,55,17,31,27,59,34,22,50,0,38,48,1,47,51,10,20,7,33,28,44,40,9,54,43,39,41,23,53,29},{7,35,55,47,40,42,29,20,50,15,54,32,56,21,57,36,44,10,38,16,49,3,8,30,28,23,14,11,6,59,2,58,26,0,48,41,19,31},{13,19,46,41,25,34,59,42,11,50,10,20,44,2,32,0,30,53,31,6,14,15,4,38,16,28,17,39,27,58,35,40,45,55,33,24,23,43,52,3,51,49,21,37,22,7,5,56,8,26,18},{12,5,27,20,36,9,50,51,29,7,1,32,43,23,15,39,58,17,11,55,18,54,53,56,14,0,19,37,31,45,38,41,44,25,52,10,6,21,57,4,42,35,30,40,49,26,46,28,3,8,13},{23,11,13,9,34,36,19,25,26,39,43,59,12,42,37,16,29,51,8,46,27,2,50,5,3,10,41,1,38,7,15,4,58,47,44,35,53,6,17,30,48,40,24,52,32,31},{33,2,37,1,16,47,46,29,48,57,0,41,21,39,18,45,36,44,3,31,53,58,10,17,28,34,49,22,6,30,51,12,13,54,38,40,25,9,26,43,5,35},{24,44,58,11,35,28,9,36,25,54,48,3,42,41,26,52,13,22,6,55,14,2,7,21,49,37,17,39,33,8,45,4,50,30,27,5,1,47,53,59,20,56,18,15,29,38,16},{40,13,34,17,8,7,36,29,22,43,30,20,51,21,26,6,58,18,0,32,54,2,38,39,44,59,12,37,48,27,1,24,33,28,31,25,47,56,11,16,41,57,49,14,42,19,15},{2,59,6,32,26,29,31,55,35,9,42,54,10,57,13,37,12,47,18,15,48,24,58,28,30,50,56,4,34,43,0,41,14,25,21,27,20,36,49,51,11,33,39,17,16,22,45},{29,9,26,30,21,35,16,32,18,43,23,22,51,13,31,53,46,41,56,48,27,20,12,0,6,34,52,17,59,14,19,36,10,24,33,4,40,11,42,58,38,7,50,57,37,45,44,39,28,8,55},{33,22,29,46,14,37,30,53,9,6,15,2,34,45,8,48,5,41,51,24,13,17,0,11,40,44,7,27,58,31,21,43,38,47,1,56,57,19,4,25,12,36,39,32,54,16},{41,57,8,36,30,24,7,23,12,33,17,29,42,46,54,48,53,19,58,0,21,1,27,34,5,32,59,18,16,4,40,55,35,20,26,52,51,9,47,15,38,14,22,39,10},{56,31,0,35,4,7,33,39,50,6,15,53,23,29,32,46,22,59,42,41,24,11,34,3,25,28,27,44,26,40,55,13,54,37,48,18,38,9,12,52,30,16,43,2,58,17},{18,51,5,19,3,26,16,38,45,0,30,42,4,48,53,52,13,39,17,50,1,59,56,47,55,14,28,37,7,8,34,23,41,54,22,33,49,20,2,21,46,36,35,9,6,29,15,12,10,57,31},{53,0,41,23,21,11,47,15,7,17,27,1,22,20,12,3,49,33,45,24,39,57,40,37,13,25,36,8,54,58,52,14,35,2,56,19,42,31,38,34,51,46,16,28,26,5,4}};

                
                List<List<String>> watchedVideos = new ArrayList<>();
                
                for(String[] sList : vid) {
                    List<String> aList = new ArrayList<>();
                    for(String s : sList) {
                        aList.add(s);
                    }
                    watchedVideos.add(aList);
                }
                
                System.out.println(watchedVideosByFriends(watchedVideos, friends, 20, 2));
    }
    

    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        // if(watchedVideos == null || watchedVideos.size() == 0 || friends == null || friends.length == 0 ||
        // id < 0 || id > friends.length -1 || level < 1) {
        // return new ArrayList<String>();
        // }

        Set<Integer> visitedFriends = new HashSet<>();
        Queue<LevelFriends> queue = new LinkedList<>();

        Set<Integer> aSet = new HashSet<Integer>();
        aSet.add(id);
        visitedFriends.add(id);
        queue.add(new LevelFriends(0, aSet));

        Set<Integer> friendsAtRequiredLevel = new HashSet<>();

        while (!queue.isEmpty()) {
            LevelFriends lf = queue.poll();
            int currLevel = lf.level;

            if (currLevel == level) {
                friendsAtRequiredLevel.addAll(lf.friendsSet);
            }

            if (currLevel < level) {
                for (Integer fId : lf.friendsSet) {
//                    if (!visitedFriends.contains(fId)) {
                        
                        Set<Integer> set = new HashSet<>();
                        for (int a : friends[fId]) {
                            if (!visitedFriends.contains(a)) {
                                visitedFriends.add(a);
                                set.add(a);
                            }
                        }
                        queue.add(new LevelFriends(currLevel + 1, set));
//                    }
                }
            }
        }

        friendsAtRequiredLevel.remove(id);

        Map<String, Integer> freqCount = new HashMap<>();

        for (Integer fId : friendsAtRequiredLevel) {
            List<String> movies = watchedVideos.get(fId);

            for (String movie : movies) {
                Integer c = freqCount.getOrDefault(movie, 0);
                freqCount.put(movie, c + 1);
            }

        }

        List<MovieFreq> mf = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqCount.entrySet()) {
            mf.add(new MovieFreq(entry.getKey(), entry.getValue()));
        }

        Collections.sort(mf, new MFComparator());

        List<String> result = new ArrayList<>(mf.size());
        for (MovieFreq m : mf) {
            result.add(m.movie);
        }
        return result;
    }

}

class LevelFriends {
    int level;
    Set<Integer> friendsSet;

    public LevelFriends(int l, Set<Integer> fs) {
        level = l;
        friendsSet = fs;
    }
}

class MovieFreq {
    String movie;
    Integer count;

    public MovieFreq(String m, Integer c) {
        movie = m;
        count = c;
    }
}

class MFComparator implements Comparator<MovieFreq> {
    @Override
    public int compare(MovieFreq m1, MovieFreq m2) {
        if (m1.count < m2.count) {
            return -1;
        } else if (m1.count > m2.count) {
            return 1;
        } else {
            return (m1.movie).compareTo(m2.movie);
        }
    }
}

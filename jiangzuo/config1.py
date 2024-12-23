# 验证码解析参数
verify_code_params = {
    'user': 'Zhang220',
    'pass': 'abc123Zhang',
    'softid': '965142',
    'codetype': 1902,
    'file_base64': ''
}

# 验证码解析请求头
verify_code_headers = {
    'Connection': 'Keep-Alive',
    'User-Agent': 'Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0)',
}

# 讲座系统请求头
lecture_headers = {
    'Accept': '*/*',
    'Accept-Encoding': 'gzip, deflate',
    'Accept-Language': 'zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6',
    'Connection': 'keep-alive',
    'Content-Length': '0',
    'Host': 'ehall.seu.edu.cn',
    'Origin': 'http://ehall.seu.edu.cn',
    'Referer': 'http://ehall.seu.edu.cn/gsapp/sys/yddjzxxtjappseu/*default/index.do',
    'User-Agent': 'Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1',
    'X-Requested-With': 'XMLHttpRequest',
    # 每次操作前修改cookie
    'Cookie':'route=de1353bd2eecd92e44c51ddb2c26661d; route=de1353bd2eecd92e44c51ddb2c26661d; GS_SESSIONID=0ad91163772b44dfc79cd606f9166a50; _WEU=eUDfp00OK5jwK*PtZASa3*u0EAEMkjKiiiHXDH0GOaBDCbrR9f2LOVWjOvXFD7US9cMBloHHMidytXDIdQd9mQuySFWjU3wco1azoYlubZRGLPtdgPdfWqZUcP4J2Ba_5XXMK7AAxW4j09hWyJK84LzewdIEFkHhzH*RuS1Vs9fWBhWerwyjZC5ZDlx3F8VBlM2Zg4Cn_J1FsQov_1G4aC5goJAZRuyuS1XX_lMiOzoQhRZ9EhMriSwP*IurUr6Gv36GYzgbCyiBJQfkpRN4zkkDdL5Oj2j0fMY7zHriRU83uI2hI0GTTxDcuQgHWM4bKKYUdpUQM5BpVCm_DYFCEc..; amp.locale=zh_CN; JSESSIONID=eYNoGqaKKIbmVS-vxXh_x5VQlrxDlWkM7ds6fO0s5lQEyOy_rvTf!-1782729770'
}



# 目标讲座关键词，请尽可能指向唯一目标
lecture_key = "【线上】【前沿科技】超导的发现与应用"
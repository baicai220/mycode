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
    'Cookie':'route=a582dc4be54fe74b7d8abd1ec14e5b0b; route=a582dc4be54fe74b7d8abd1ec14e5b0b; EMAP_LANG=zh; THEME=indigo; GS_SESSIONID=0c11162444e94b7a469a1c3e0d257954; _WEU=k6yu5GWABHijKHe86IghQ28kODX4sVAqSoOQemp_BWDfEFo1Op0nfM3FKmUMf2ZQHK8_YDb_17F1sS_a4n_xyOBrcsDaJXBGuo6kJYdoRTDEB2LtGEQMZCKtzgZ7QNTnrq4QmA1bVpID9wRQl7ppFYl11aEijTS*aXspVK6co7v*a75AFX7pNrIHeiJhaiFR7UEPo0*er1OCaglHRu2RYTHZBllazdVa6VnKiDLZBreLeUilOWkWhMESJq8vQcJW1T5tIYedLRJ17DubXYq_KCB5sT9zrJfpMPfhEj9QqXXh5q_958VlfyissFhz87HEyvKAKNOxe2oVyi2FcfEhWo..; route=a582dc4be54fe74b7d8abd1ec14e5b0b; amp.locale=zh_CN; asessionid=f20d9f7e-d8ae-459a-964b-e578ce1b2bf9; JSESSIONID=zqCl6bvOGcAHnHTgk5PFWVyM54t_kVZ-GIyZH3Ot2Cxhxyj0H6_0!-81988394'
}



# 目标讲座关键词，请尽可能指向唯一目标
lecture_key = "【线上】【艺术】具身想像——电影与建筑的教学与实践"
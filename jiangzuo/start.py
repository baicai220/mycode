import subprocess

# 要并行运行的脚本列表
scripts = ['main.py', 'main1.py']

# 使用subprocess启动所有脚本
processes = [subprocess.Popen(["python", script]) for script in scripts]

# 等待所有进程完成（可选）
for process in processes:
    process.wait()
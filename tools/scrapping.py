from bs4 import BeautifulSoup
import requests
import re

url = "https://www.elektra.com.mx/omen?lid=a48e3eb6-b3da-43e4-8a22-386d5173507e"
r = requests.get(url)
html_doc = r.text
soup = BeautifulSoup(html_doc, features="lxml")
print(soup.title)
for item in soup.find_all('div'):
    print(item)
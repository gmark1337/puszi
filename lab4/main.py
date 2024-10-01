import cv2
import numpy as np
#A feladat első része: egy képet HSV-é alakítani és bekérni a felhasználótól 1-3 színt
#Ezeket a színeket egy tetszőleges képen kiszűrni maszkolás segítségével
#Második része:bekérni a felhasználótól hány %-ban szűrkítsen a képen
#Harmadik pedig egy színtörlés volt
#fun fact maszkolás se sikerült :DDDD
img = cv2.imread("apple.jpg")
hsv_img = cv2.cvtColor(img, cv2.COLOR_RGB2HSV)
cv2.waitKey(0)
def get_color_input(color_num):
    print(f"Kérlek add meg a(z) {color_num}. szín HSV értékeit (Hue, Saturation, Value)!")
    h = int(input(f"Add meg a(z) {color_num}. szín Hue értékét (0-179): "))
    s = int(input(f"Add meg a(z) {color_num}. szín Saturation értékét (0-255): "))
    v = int(input(f"Add meg a(z) {color_num}. szín Value értékét (0-255): "))
    return np.array([h, s, v])

colors = []
for i in range(1, 4):
    color = get_color_input(i)
    colors.append(color)
#MÉNEMJÓ
for idx, color in enumerate(colors):
    lower_bound = np.array([max(0, color[0]-10), max(0, color[1]-40), max(0, color[2]-40)])
    upper_bound = np.array([min(179, color[0]+10), min(255, color[1]+40), min(255, color[2]+40)])
mask = cv2.inRange(hsv_img, lower_bound, upper_bound)
result = cv2.bitwise_and(img, img, mask=mask)

cv2.imshow("mask", mask)
cv2.imshow("eredmeny", result)

cv2.waitKey(0)
cv2.destroyAllWindows()

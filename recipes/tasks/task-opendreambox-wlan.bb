DESCRIPTION = "OpenDreambox: W-LAN Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r2"

inherit task

#
# task-opendreambox-wlan
#
DESCRIPTION_${PN} = "OpenDreambox: W-LAN Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
  enigma2-plugin-systemplugins-wirelesslan \
  wireless-tools \
  wpa-supplicant \
"

WLAN_CRYPTO_MODULES = "\
  kernel-module-aes-generic \
  kernel-module-arc4 \
  kernel-module-cryptomgr \
  kernel-module-ecb \
"

WLAN_PCI_MODULES = "\
  kernel-module-ath5k \
"

WLAN_USB_MODULES = "\
  kernel-module-rt73usb \
  kernel-module-zd1211rw \
  rt73-firmware \
  zd1211-firmware \
"

RDEPENDS_${PN}_append_dm800 = "\
  wlan-rt73 \
  zd1211b \
"

RDEPENDS_${PN}_append_dm8000 = "\
  ${WLAN_CRYPTO_MODULES} \
  ${WLAN_PCI_MODULES} \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"


DESCRIPTION = "OpenDreambox: W-LAN Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r1"

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

RDEPENDS_${PN}_append_dm800 = "\
  wlan-rt73 \
  zd1211b \
"

RDEPENDS_${PN}_append_dm8000 = "\
  task-opendreambox-madwifi \
  wlan-rt73 \
  zd1211b \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"


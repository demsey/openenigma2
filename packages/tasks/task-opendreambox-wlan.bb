DESCRIPTION = "OpenDreambox: W-LAN Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-wlan
#
DESCRIPTION_${PN} = "OpenDreambox: W-LAN Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
  enigma2-plugin-systemplugins-wirelesslan \
  wireless-tools \
  wlan-rt73 \
  wpa-supplicant \
  zd1211b \
"

RDEPENDS_${PN}_append_dm8000 = "\
  task-opendreambox-madwifi \
"

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"


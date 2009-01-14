DESCRIPTION = "OpenDreambox: Base Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-base
#
DESCRIPTION_${PN} = "OpenDreambox: Basesystem utilities"
RDEPENDS_${PN} = "\
  autofs \
  base-files-doc \
  dreambox-bootlogo \
  dreambox-compat \
  dreambox-dccamd \
  dreambox-feed-configs \
  dreambox-keymaps \
  dropbear \
  dvbsnoop \
  e2fsprogs-e2fsck \
  e2fsprogs-mke2fs \
  fakelocale \
  gdbserver \
  hddtemp \
  joe \
  mc \
  module-init-tools-depmod \
  mrouted \
  netkit-base \
  ncurses \
  opkg-nogpg \
  ppp \
  smartmontools \
  timezones-alternative \
  tuxbox-common \
  vsftpd \
  util-linux-fdisk \
  util-linux-sfdisk \
"


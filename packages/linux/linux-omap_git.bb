require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3|omap2430sdp|omap2420h4|beagleboard|omap3evm"


SRCREV = "e1c49d7d22af768188e2a54c167ed79919361e55"

PV = "2.6.26+2.6.27-rc7+${PR}+git${SRCREV}"
PR = "r14"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
	   file://defconfig"

SRC_URI_append = " \
           file://no-empty-flash-warnings.patch;patch=1 \
           file://oprofile-0.9.3.armv7.diff;patch=1 \
           file://no-cortex-deadlock.patch;patch=1 \
           file://read_die_ids.patch;patch=1 \
           file://fix-install.patch;patch=1 \
           file://musb-dma-iso-in.eml;patch=1 \
           file://musb-support-high-bandwidth.patch.eml;patch=1 \
           file://musb-mru-otgfix.diff;patch=1 \
           file://mru-fix-timings.diff;patch=1 \
           file://mru-fix-display-panning.diff;patch=1 \
           file://mru-make-dpll4-m4-ck-programmable.diff;patch=1 \
           file://mru-add-clk-get-parent.diff;patch=1 \
           file://mru-improve-pixclock-config.diff;patch=1 \
           file://mru-make-video-timings-selectable.diff;patch=1 \
           file://mru-enable-overlay-optimalization.diff;patch=1 \
           file://musb-fix-ISO-in-unlink.diff;patch=1 \
           file://musb-fix-multiple-bulk-transfers.diff;patch=1 \
           file://mru-256MB.diff;patch=1 \
           file://musb-fix-endpoints.diff;patch=1 \
           file://dvb-fix-dma.diff;patch=1 \
           file://fix-irq33.diff;patch=1 \
"


SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
                               file://beagle-asoc.diff;patch=1 \
			     "

SRC_URI_append_omap3evm = " \
"

S = "${WORKDIR}/git"


module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"


package rudyAir.model;

public class Views {

	public static class Common {

	}

	public static class AeroportWithVolsGeneneriquesDeparts extends Common {

	}

	public static class AeroportWithVolsGeneneriquesArrivees extends Common {

	}

	public static class AeroportWithVille extends Common {

	}

	public static class VilleWithAeroports extends Common {

	}

	// VolGen
	public static class VolGeneneriqueWithVol extends Common {

	}

	public static class VolGeneneriquetWithAeroport extends Common {

	}

	public static class VolGeneneriqueWithHoraire extends VolGeneneriquetWithAeroport {

	}

	// Passager
	public static class PassagerWithReservation extends Common {

	}

	// Reservation
	public static class Reservation extends Common {

	}

	public static class ReservationPassagerWithClient extends Common {

	}

	public static class ReservationPassagerWithVol extends Common {

	}

	// Siege
	public static class SiegeWithReservationAndAvion extends Common {

	}

	// Avion
	public static class AvionWithSiege extends Common {

	}

	// Vol
	
	public static class Vol extends Common {

	}
	public static class VolWithVolGenAndAvion extends Common {

	}

	public static class VolWithAeroport extends VolWithVolGenAndAvion {

	}

	// Compte
	public static class CompteClient extends Common {

	}
	
	public static class CompteAdmin extends Common {

	}

	public static class CompteClientWithReservation extends CompteClient {

	}

}



export class Horaire {
  private _heureDepart : Date | undefined;
  private _heureArrivee :  Date | undefined;


	constructor(heureDepart: Date , heureArrivee:  Date ) {
		this._heureDepart = heureDepart;
		this._heureArrivee = heureArrivee;

}

    /**
     * Getter heureDepart
     * @return {Date }
     */
	public get heureDepart(): Date | undefined {
		return this._heureDepart;
	}

    /**
     * Getter heureArrivee
     * @return { Date }
     */
	public get heureArrivee():  Date | undefined {
		return this._heureArrivee;
	}

    /**
     * Setter heureDepart
     * @param {Date } value
     */
	public set heureDepart(value: Date | undefined) {
		this._heureDepart = value;
	}

    /**
     * Setter heureArrivee
     * @param { Date } value
     */
	public set heureArrivee(value:  Date | undefined) {
		this._heureArrivee = value;
	}

}

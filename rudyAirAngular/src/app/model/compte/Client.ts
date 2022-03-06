import { Abonnement } from './abonnement';
import { Adresse } from './adresse';
import { Compte } from './compte';

export class Client extends Compte {
  private _adresse: Adresse | undefined;
  private _abonnement: Abonnement | undefined;

  constructor(adresse?: Adresse, abonnement?: Abonnement) {
    super();
    this._adresse = adresse;
    this._abonnement = abonnement;
  }

  /**
   * Getter adresse
   * @return {Adresse }
   */
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  /**
   * Getter abonnement
   * @return {Abonnement }
   */
  public get abonnement(): Abonnement | undefined {
    return this._abonnement;
  }

  /**
   * Setter adresse
   * @param {Adresse } value
   */
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  /**
   * Setter abonnement
   * @param {Abonnement } value
   */
  public set abonnement(value: Abonnement | undefined) {
    this._abonnement = value;
  }
}

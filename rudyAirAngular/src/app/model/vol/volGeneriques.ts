import { Aeroport } from './aeroport';
import { Horaire } from './horaire';
export class VolGenerique {
  private _id: number | undefined;
  private _prix: number | undefined;
  private _numVolGen: string | undefined;
  private _horaire: Horaire | undefined;
  private _aeroportDepart: Aeroport | undefined;
  private _aeroportArrivee: Aeroport | undefined;

  constructor(
    id: number,
    prix: number,
    numVolGen: string,
    horaire: Horaire,
    aeroportDepart: Aeroport,
    aeroportArrivee: Aeroport
  ) {
    this._id = id;
    this._prix = prix;
    this._numVolGen = numVolGen;
    this._horaire = horaire;
    this._aeroportDepart = aeroportDepart;
    this._aeroportArrivee = aeroportArrivee;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter prix
   * @return {number }
   */
  public get prix(): number | undefined {
    return this._prix;
  }

  /**
   * Getter numVolGen
   * @return {string }
   */
  public get numVolGen(): string | undefined {
    return this._numVolGen;
  }

  /**
   * Getter horaire
   * @return {Horaire }
   */
  public get horaire(): Horaire | undefined {
    return this._horaire;
  }

  /**
   * Getter aeroportDepart
   * @return {Aeroport }
   */
  public get aeroportDepart(): Aeroport | undefined {
    return this._aeroportDepart;
  }

  /**
   * Getter aeroportArrivee
   * @return {Aeroport }
   */
  public get aeroportArrivee(): Aeroport | undefined {
    return this._aeroportArrivee;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter prix
   * @param {number } value
   */
  public set prix(value: number | undefined) {
    this._prix = value;
  }

  /**
   * Setter numVolGen
   * @param {string } value
   */
  public set numVolGen(value: string | undefined) {
    this._numVolGen = value;
  }

  /**
   * Setter horaire
   * @param {Horaire } value
   */
  public set horaire(value: Horaire | undefined) {
    this._horaire = value;
  }

  /**
   * Setter aeroportDepart
   * @param {Aeroport } value
   */
  public set aeroportDepart(value: Aeroport | undefined) {
    this._aeroportDepart = value;
  }

  /**
   * Setter aeroportArrivee
   * @param {Aeroport } value
   */
  public set aeroportArrivee(value: Aeroport | undefined) {
    this._aeroportArrivee = value;
  }
}

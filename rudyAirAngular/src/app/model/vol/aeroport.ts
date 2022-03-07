import { Ville } from './ville';
export class Aeroport {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _ville: Ville | undefined;

  constructor(id: number, nom: string, ville: Ville) {
    this._id = id;
    this._nom = nom;
    this._ville = ville;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter ville
   * @return {ville}
   */
  public get ville(): Ville | undefined {
    return this._ville;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter ville
   * @param {ville} value
   */
  public set ville(value: Ville | undefined) {
    this._ville = value;
  }
}

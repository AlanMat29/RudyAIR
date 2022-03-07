export class Ville {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _pays: string | undefined;
  private _cp: string | undefined;
  private _aeroports: Aeroports | undefined;

  constructor(
    id?: number,
    nom?: string,
    pays?: string,
    cp?: string,
    aeroports?: Aeroports
  ) {
    this._id = id;
    this._nom = nom;
    this._pays = pays;
    this._cp = cp;
    this._aeroports = aeroports;
  }

  /**
   * Getter id
   * @return {string }
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
   * Getter pays
   * @return {string }
   */
  public get pays(): string | undefined {
    return this._pays;
  }

  /**
   * Getter cp
   * @return {string }
   */
  public get cp(): string | undefined {
    return this._cp;
  }

  /**
   * Getter aeroports
   * @return {Aeroports }
   */
  public get aeroports(): Aeroports | undefined {
    return this._aeroports;
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
   * Setter pays
   * @param {string } value
   */
  public set pays(value: string | undefined) {
    this._pays = value;
  }

  /**
   * Setter cp
   * @param {string } value
   */
  public set cp(value: string | undefined) {
    this._cp = value;
  }

  /**
   * Setter aeroports
   * @param {Aeroports } value
   */
  public set aeroports(value: Aeroports) {
    this._aeroports = value;
  }
}
